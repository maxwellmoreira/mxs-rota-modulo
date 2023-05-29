package com.mxs.rota.requisicao;

import lombok.Builder;

/**
 * Classe responsável por representar a requisição de filtro para busca de Entregador no controlador.
 */
@Builder
public record EntregadorControladorObterRequisicao(
        String codigo,
        String username,
        String email) {
}
