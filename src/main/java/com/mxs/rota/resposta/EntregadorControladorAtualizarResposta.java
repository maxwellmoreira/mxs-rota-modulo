package com.mxs.rota.resposta;

import lombok.Builder;

/**
 * Classe responsável por representar a resposta da atualização de um Entregador no controlador.
 */
@Builder
public record EntregadorControladorAtualizarResposta(String codigo) {
}

