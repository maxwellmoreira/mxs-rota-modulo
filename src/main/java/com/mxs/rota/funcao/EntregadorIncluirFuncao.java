package com.mxs.rota.funcao;

import com.mxs.rota.conversor.EntregadorConversor;
import com.mxs.rota.repositorio.EntregadorRepositorio;
import com.mxs.rota.requisicao.EntregadorControladorCriarRequisicao;
import com.mxs.rota.resposta.EntregadorControladorCriarResposta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Classe responsável pelo caso de uso de inclusão da entidade Entregador.
 */
@Service
public class EntregadorIncluirFuncao {

    @Autowired
    private EntregadorConversor entregadorConversor;
    @Autowired
    private EntregadorRepositorio entregadorRepositorio;

    /**
     * Método responsável por incluir um Entregador.
     *
     * @param entregadorControladorCriarRequisicao objeto contendo os atributos do Entregador
     * @return objeto contendo o código de identificação do Entregador incluído
     */
    public EntregadorControladorCriarResposta criarEntregador(EntregadorControladorCriarRequisicao entregadorControladorCriarRequisicao) {

        var entregadorModelo = this.entregadorConversor.controladorCriarRequisicaoParaModelo(entregadorControladorCriarRequisicao);

        entregadorModelo.ficarOffline();

        var codigoEntregador = this.entregadorRepositorio.save(entregadorModelo).getCodigo();

        return this.entregadorConversor.modeloParaControladorCriarResposta(codigoEntregador);
    }
}
