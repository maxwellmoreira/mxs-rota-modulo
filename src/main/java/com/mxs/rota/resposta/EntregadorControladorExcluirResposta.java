package com.mxs.rota.resposta;

import lombok.Builder;

/**
 * Classe responsável por representar a resposta da exclusão de um Entregador no controlador.
 */
@Builder
public record EntregadorControladorExcluirResposta(String codigo) {
}
