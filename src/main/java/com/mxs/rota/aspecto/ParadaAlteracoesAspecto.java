package com.mxs.rota.aspecto;

import com.mxs.rota.excecao.NaoMapeadaExcecao;
import com.mxs.rota.requisicao.*;
import com.mxs.rota.resposta.*;
import com.mxs.rota.tipo.OperacaoTipo;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.time.Instant;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

import static com.mxs.rota.padrao.MensagemPadrao.EXCECAO_NAO_MAPEADA;

/**
 * Classe responsável por monitorar as alterações nos registros de Parada e salvar-las em cache.
 */
@Aspect
@Component
public class ParadaAlteracoesAspecto {

    private static final String ENTRADA = "entrada";
    private static final String QUANDO = "quando";

    @Autowired
    private RedisTemplate redisTemplate;

    @Pointcut("execution(* com.mxs.rota.controlador.ParadaControlador.criarParada(..)) || " +
            "execution(* com.mxs.rota.controlador.ParadaControlador.atualizarParada(..)) || " +
            "execution(* com.mxs.rota.controlador.ParadaControlador.excluirParada(..))")
    public void monitorarAlteracoesParada() {
    }

    /**
     * Método responsável por analisar o tipo de resposta de cada solicitação, encapsular suas informações e salvá-las em cache.
     *
     * @param joinPoint ponto de corte do aspecto que monitora os serviços de alteração de Parada
     * @param responseEntity o retorno de cada serviço que altera algum registro de Parada
     */
    @AfterReturning(pointcut = "monitorarAlteracoesParada()", returning = "responseEntity")
    public void monitorarPorRetorno(JoinPoint joinPoint, Object responseEntity) {

        var agora = Instant.now().toString();
        Object[] args = joinPoint.getArgs();
        var retorno = (ResponseEntity) responseEntity;

        switch (retorno.getBody().getClass().getName()) {

            case "com.mxs.rota.resposta.ParadaControladorCriarResposta":

                var paradaControladorCriarRequisicao = (ParadaControladorCriarRequisicao) args[0];
                var paradaControladorCriarResposta = (ParadaControladorCriarResposta) retorno.getBody();

                Map<String, String> valoresCriarParada = new HashMap<>();
                valoresCriarParada.put(ENTRADA, paradaControladorCriarRequisicao.toString());
                valoresCriarParada.put(QUANDO, agora);

                salvarOperacaoEmCache(OperacaoTipo.CRIAR_PARADA, paradaControladorCriarResposta.codigo(), valoresCriarParada);
                break;

            case "com.mxs.rota.resposta.ParadaControladorAtualizarResposta":

                var paradaControladorAtualizarRequisicao = (ParadaControladorAtualizarRequisicao) args[1];
                var paradaControladorAtualizarResposta = (ParadaControladorAtualizarResposta) retorno.getBody();

                Map<String, String> valoresAtualizarParada = new HashMap<>();
                valoresAtualizarParada.put(ENTRADA, paradaControladorAtualizarRequisicao.toString());
                valoresAtualizarParada.put(QUANDO, agora);

                salvarOperacaoEmCache(OperacaoTipo.ATUALIZAR_PARADA, paradaControladorAtualizarResposta.codigo(), valoresAtualizarParada);
                break;

            case "com.mxs.rota.resposta.ParadaControladorExcluirResposta":

                var codigoParadaExcluir = (String) args[0];
                var paradaControladorExcluirResposta = (ParadaControladorExcluirResposta) retorno.getBody();

                Map<String, String> valoresExcluirParada = new HashMap<>();
                valoresExcluirParada.put(ENTRADA, codigoParadaExcluir);
                valoresExcluirParada.put(QUANDO, agora);

                salvarOperacaoEmCache(OperacaoTipo.EXCLUIR_PARADA, paradaControladorExcluirResposta.codigo(), valoresExcluirParada);
                break;

            default:
                throw new NaoMapeadaExcecao(EXCECAO_NAO_MAPEADA);
        }
    }

    /**
     * Método responsável por salvar as operações de alteração de registro de Parada no Redis.
     *
     * @param operacaoTipo CRIAR_PARADA ou ATUALIZAR_PARADA ou EXCLUIR_PARADA
     * @param codigo       código identificador da Parada
     * @param valores      valores que foram alterados no banco de dados
     */
    private void salvarOperacaoEmCache(OperacaoTipo operacaoTipo, String codigo, Map<String, String> valores) {
        CompletableFuture.runAsync(() -> {
            try {
                redisTemplate.opsForHash().put(operacaoTipo, codigo, valores);
            } catch (Exception e) {
            }
        });
    }
}
