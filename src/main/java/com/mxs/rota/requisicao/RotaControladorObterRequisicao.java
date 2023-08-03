package com.mxs.rota.requisicao;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;

/**
 * Classe responsável por representar a requisição de filtro para busca de Rotas no controlador.
 */
@Builder
public record RotaControladorObterRequisicao(
        @JsonProperty("codigo")
        String codigo,
        @JsonProperty("data")
        String data,
        @JsonProperty("status_rota")
        String statusRota) {
}