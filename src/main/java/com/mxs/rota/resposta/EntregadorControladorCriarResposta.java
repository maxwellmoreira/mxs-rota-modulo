package com.mxs.rota.resposta;

import lombok.Builder;

/**
 * Classe responsável por representar a resposta da criação de um Entregador no controlador.
 */
@Builder
public record EntregadorControladorCriarResposta (String codigo) {
}
