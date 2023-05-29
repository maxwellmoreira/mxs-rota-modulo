package com.mxs.rota.conversor;

import com.mxs.rota.modelo.EntregadorModelo;
import com.mxs.rota.requisicao.EntregadorControladorCriarRequisicao;
import com.mxs.rota.resposta.EntregadorControladorCriarResposta;
import org.springframework.stereotype.Component;

/**
 * Classe responsável por converter requisições, respostas e dto's relacionados com a entidade Entregador.
 */
@Component
public class EntregadorConversor {

    public EntregadorModelo controladorCriarRequisicaoParaModelo(EntregadorControladorCriarRequisicao entregadorControladorCriarRequisicao) {
        return EntregadorModelo
                .builder()
                .username(entregadorControladorCriarRequisicao.username())
                .email(entregadorControladorCriarRequisicao.email())
                .build();
    }

    public EntregadorControladorCriarResposta modeloParaControladorCriarResposta(String codigoEntregador) {
        return EntregadorControladorCriarResposta
                .builder()
                .codigo(codigoEntregador)
                .build();
    }
}
