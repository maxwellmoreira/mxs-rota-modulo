package com.mxs.rota.fachada;

import com.mxs.rota.funcao.TrajetoIncluirFuncao;
import com.mxs.rota.requisicao.TrajetoControladorCriarRequisicao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Classe responsável por agrupar todos os casos de uso do domínio Trajeto.
 */
@Service
public class TrajetoFachada {

    @Autowired
    private TrajetoIncluirFuncao trajetoIncluirFuncao;

    public void criarTrajeto(TrajetoControladorCriarRequisicao trajetoControladorCriarRequisicao) {
        this.trajetoIncluirFuncao.criarTrajeto(trajetoControladorCriarRequisicao);
    }
}
