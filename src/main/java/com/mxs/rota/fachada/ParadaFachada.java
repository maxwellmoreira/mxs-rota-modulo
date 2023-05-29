package com.mxs.rota.fachada;

import com.mxs.rota.funcao.ParadaAtualizarFuncao;
import com.mxs.rota.funcao.ParadaExcluirFuncao;
import com.mxs.rota.funcao.ParadaIncluirFuncao;
import com.mxs.rota.funcao.ParadaObterFuncao;
import com.mxs.rota.requisicao.ParadaControladorAtualizarRequisicao;
import com.mxs.rota.requisicao.ParadaControladorCriarRequisicao;
import com.mxs.rota.requisicao.ParadaControladorExcluirRequisicao;
import com.mxs.rota.requisicao.ParadaControladorObterRequisicao;
import com.mxs.rota.resposta.ParadaControladorAtualizarResposta;
import com.mxs.rota.resposta.ParadaControladorCriarResposta;
import com.mxs.rota.resposta.ParadaControladorExcluirResposta;
import com.mxs.rota.resposta.ParadaControladorObterResposta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Classe responsável por agrupar todos os casos de uso do domínio Parada.
 */
@Service
public class ParadaFachada {

    @Autowired
    private ParadaIncluirFuncao paradaIncluirFuncao;
    @Autowired
    private ParadaObterFuncao paradaObterFuncao;
    @Autowired
    private ParadaAtualizarFuncao paradaAtualizarFuncao;
    @Autowired
    private ParadaExcluirFuncao paradaExcluirFuncao;

    /**
     * Método responsável por chamar o caso de uso referente à criação de Parada.
     *
     * @param paradaControladorCriarRequisicaoLista lista de Paradas
     * @return lista de códigos das Paradas incluídas
     */
    public List<ParadaControladorCriarResposta> criarParadas(List<ParadaControladorCriarRequisicao> paradaControladorCriarRequisicaoLista) {
        return paradaControladorCriarRequisicaoLista.stream().map(this::criarParada).collect(Collectors.toList());
    }

    /**
     * Método responsável por chamar o caso de uso referente à criação de Parada.
     *
     * @param paradaControladorCriarRequisicao objeto contendo os atributos da Parada
     * @return objeto contendo o código de identificação da Parada incluída
     */
    public ParadaControladorCriarResposta criarParada(ParadaControladorCriarRequisicao paradaControladorCriarRequisicao) {
        return this.paradaIncluirFuncao.criarParada(paradaControladorCriarRequisicao);
    }

    /**
     * Método responsável por chamar o caso de uso referente à pesquisa de Paradas.
     *
     * @param paradaControladorObterRequisicao objeto contendo os filtros de busca
     * @return lista de Paradas encontradas
     */
    public List<ParadaControladorObterResposta> obterParadas(ParadaControladorObterRequisicao paradaControladorObterRequisicao) {
        return this.paradaObterFuncao.obterParadas(paradaControladorObterRequisicao);
    }

    /**
     * Método responsável por chamar o caso de uso referente à atualização de Parada.
     *
     * @param paradaControladorAtualizarRequisicaoLista lista de Paradas
     * @return lista de códigos das Paradas atualizadas
     */
    public List<ParadaControladorAtualizarResposta> atualizarParadas(List<ParadaControladorAtualizarRequisicao> paradaControladorAtualizarRequisicaoLista) {
        return paradaControladorAtualizarRequisicaoLista.stream().map(this::atualizarParada).collect(Collectors.toList());
    }

    /**
     * Método responsável por chamar o caso de uso referente à atualização de Parada.
     *
     * @param paradaControladorAtualizarRequisicao objeto contendo os atributos que podem ser atualizados da Parada
     * @return objeto contendo o código da Parada atualizada
     */
    public ParadaControladorAtualizarResposta atualizarParada(ParadaControladorAtualizarRequisicao paradaControladorAtualizarRequisicao) {
        return this.paradaAtualizarFuncao.atualizarParada(paradaControladorAtualizarRequisicao);
    }

    /**
     * Método responsável por chamar o caso de uso referente à exclusão de Parada.
     *
     * @param paradaControladorExcluirRequisicao objeto contendo o código da Parada
     * @return objeto contendo o código da Parada excluída
     */
    public ParadaControladorExcluirResposta excluirParada(ParadaControladorExcluirRequisicao paradaControladorExcluirRequisicao) {
        return this.paradaExcluirFuncao.excluirParada(paradaControladorExcluirRequisicao);
    }
}
