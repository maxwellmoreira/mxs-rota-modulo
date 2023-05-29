package com.mxs.rota.fachada;

import com.mxs.rota.excecao.NaoEncontradoExcecao;
import com.mxs.rota.funcao.EntregadorIncluirFuncao;
import com.mxs.rota.modelo.EntregadorModelo;
import com.mxs.rota.requisicao.EntregadorControladorAtualizarRequisicao;
import com.mxs.rota.requisicao.EntregadorControladorCriarRequisicao;
import com.mxs.rota.requisicao.EntregadorControladorExcluirRequisicao;
import com.mxs.rota.requisicao.EntregadorControladorObterRequisicao;
import com.mxs.rota.resposta.EntregadorControladorAtualizarResposta;
import com.mxs.rota.resposta.EntregadorControladorCriarResposta;
import com.mxs.rota.resposta.EntregadorControladorExcluirResposta;
import com.mxs.rota.resposta.EntregadorControladorObterResposta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Classe responsável por agrupar todos os casos de uso do domínio Entregador.
 */
@Service
public class EntregadorFachada {

    @Autowired
    EntregadorIncluirFuncao entregadorIncluirFuncao;

    /**
     * Método responsável por chamar o caso de uso referente à criação do Entregador.
     *
     * @param entregadorControladorCriarRequisicaoLista lista de Entregadores
     * @return lista de códigos dos Entregadores incluídos
     */
    public List<EntregadorControladorCriarResposta> criarEntregadores(List<EntregadorControladorCriarRequisicao> entregadorControladorCriarRequisicaoLista) {
        return entregadorControladorCriarRequisicaoLista.stream().map(this::criarEntregador).collect(Collectors.toList());
    }

    /**
     * Método responsável por chamar o caso de uso referente à criação do Entregador.
     *
     * @param entregadorControladorCriarRequisicao objeto contendo os atributos do Entregador
     * @return objeto contendo o código de identificação do Entregador incluído
     */
    public EntregadorControladorCriarResposta criarEntregador(EntregadorControladorCriarRequisicao entregadorControladorCriarRequisicao) {
        return this.entregadorIncluirFuncao.criarEntregador(entregadorControladorCriarRequisicao);
    }

    /**
     * Método responsável por chamar o caso de uso referente à pesquisa do Entregador.
     *
     * @param entregadorControladorObterRequisicao objeto contendo os filtros de busca
     * @return Entregador encontrado
     */
    public List<EntregadorControladorObterResposta> obterEntregador(EntregadorControladorObterRequisicao entregadorControladorObterRequisicao) {
        return null;
    }

    /**
     * Método responsável por pesquisar por um Entregador.
     *
     * @param codigoEntregador código do Entregador
     * @return objeto Entregador encontrado
     * @throws NaoEncontradoExcecao lançado quando não for encontrado um Entregador
     */
    public EntregadorModelo obterEntregadorPorCodigo(String codigoEntregador) {
        return null;
    }

    /**
     * Método responsável por chamar o caso de uso referente à atualização do Entregador.
     *
     * @param entregadorControladorAtualizarRequisicao objeto contendo os atributos que podem ser atualizados do Entregador
     * @return objeto contendo o código do Entregador atualizado
     */
    public EntregadorControladorAtualizarResposta atualizarEntregador(EntregadorControladorAtualizarRequisicao entregadorControladorAtualizarRequisicao) {
        return null;
    }

    /**
     * Método responsável por chamar o caso de uso referente à exclusão do Entregador.
     *
     * @param entregadorControladorExcluirRequisicao objeto contendo o código do Entregador
     * @return objeto contendo o código do Entregador excluído
     */
    public EntregadorControladorExcluirResposta excluirEntregador(EntregadorControladorExcluirRequisicao entregadorControladorExcluirRequisicao) {
        return null;
    }
}
