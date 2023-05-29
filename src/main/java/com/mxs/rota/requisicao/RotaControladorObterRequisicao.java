package com.mxs.rota.requisicao;

import lombok.Builder;

/**
 * Classe responsável por representar a requisição de filtro para busca de Rotas no controlador.
 */
@Builder
public record RotaControladorObterRequisicao(
        String codigo,
        String data,
        String statusRota) {
}