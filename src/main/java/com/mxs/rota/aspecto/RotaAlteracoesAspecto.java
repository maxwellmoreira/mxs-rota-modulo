package com.mxs.rota.aspecto;

import com.mxs.rota.excecao.NaoMapeadaExcecao;
import com.mxs.rota.requisicao.RotaControladorAtualizarRequisicao;
import com.mxs.rota.requisicao.RotaControladorCriarRequisicao;
import com.mxs.rota.resposta.RotaControladorAtualizarResposta;
import com.mxs.rota.resposta.RotaControladorCriarResposta;
import com.mxs.rota.resposta.RotaControladorExcluirResposta;
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
 * Classe responsável por monitorar as alterações nos registros de Rota e salvar-las em cache.
 */
@Aspect
@Component
public class RotaAlteracoesAspecto {

    private static final String ENTRADA = "entrada";
    private static final String QUANDO = "quando";

    @Autowired
    private RedisTemplate redisTemplate;

    @Pointcut("execution(* com.mxs.rota.controlador.RotaControlador.criarRota(..)) || " +
            "execution(* com.mxs.rota.controlador.RotaControlador.atualizarRota(..)) || " +
            "execution(* com.mxs.rota.controlador.RotaControlador.excluirRota(..))")
    public void monitorarAlteracoesRota() {
    }

    /**
     * Método responsável por analisar o tipo de resposta de cada solicitação, encapsular suas informações e salvá-las em cache.
     *
     * @param joinPoint      ponto de corte do aspecto que monitora os serviços de alteração de Rota
     * @param responseEntity o retorno de cada serviço que altera algum registro de Rota
     */
    @AfterReturning(pointcut = "monitorarAlteracoesRota()", returning = "responseEntity")
    public void monitorarPorRetorno(JoinPoint joinPoint, Object responseEntity) {

        var agora = Instant.now().toString();
        Object[] args = joinPoint.getArgs();
        var retorno = (ResponseEntity) responseEntity;

        switch (retorno.getBody().getClass().getName()) {

            case "com.mxs.rota.resposta.RotaControladorCriarResposta":

                var rotaControladorCriarRequisicao = (RotaControladorCriarRequisicao) args[0];
                var rotaControladorCriarResposta = (RotaControladorCriarResposta) retorno.getBody();

                Map<String, String> valoresCriarRota = new HashMap<>();
                valoresCriarRota.put(ENTRADA, rotaControladorCriarRequisicao.toString());
                valoresCriarRota.put(QUANDO, agora);

                salvarOperacaoEmCache(OperacaoTipo.CRIAR_ROTA, rotaControladorCriarResposta.codigo(), valoresCriarRota);
                break;

            case "com.mxs.rota.resposta.RotaControladorAtualizarResposta":

                var rotaControladorAtualizarRequisicao = (RotaControladorAtualizarRequisicao) args[1];
                var rotaControladorAtualizarResposta = (RotaControladorAtualizarResposta) retorno.getBody();

                Map<String, String> valoresAtualizarRota = new HashMap<>();
                valoresAtualizarRota.put(ENTRADA, rotaControladorAtualizarRequisicao.toString());
                valoresAtualizarRota.put(QUANDO, agora);

                salvarOperacaoEmCache(OperacaoTipo.ATUALIZAR_ROTA, rotaControladorAtualizarResposta.codigo(), valoresAtualizarRota);
                break;

            case "com.mxs.rota.resposta.RotaControladorExcluirResposta":

                var codigoRotaExcluir = (String) args[0];
                var rotaControladorExcluirResposta = (RotaControladorExcluirResposta) retorno.getBody();

                Map<String, String> valoresExcluirRota = new HashMap<>();
                valoresExcluirRota.put(ENTRADA, codigoRotaExcluir);
                valoresExcluirRota.put(QUANDO, agora);

                salvarOperacaoEmCache(OperacaoTipo.EXCLUIR_ROTA, rotaControladorExcluirResposta.codigo(), valoresExcluirRota);
                break;

            default:
                throw new NaoMapeadaExcecao(EXCECAO_NAO_MAPEADA);
        }
    }

    /**
     * Método responsável por salvar as operações de alteração de registro de Rota no Redis.
     *
     * @param operacaoTipo CRIAR_ROTA ou ATUALIZAR_ROTA ou EXCLUIR_ROTA
     * @param codigo       código identificador da Rota
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
