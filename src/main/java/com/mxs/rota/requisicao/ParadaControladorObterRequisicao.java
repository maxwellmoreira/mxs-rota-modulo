package com.mxs.rota.requisicao;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;

/**
 * Classe responsável por representar a requisição de filtro para busca de Paradas no controlador.
 */
@Builder
public record ParadaControladorObterRequisicao(
        @JsonProperty("codigo")
        String codigo,
        @JsonProperty("descricao")
        String descricao,
        @JsonProperty("endereco")
        String endereco,
        @JsonProperty("latitude")
        String latitude,
        @JsonProperty("longitude")
        String longitude,
        @JsonProperty("raio_entrega")
        String raioEntrega,
        @JsonProperty("status_parada")
        String statusParada,
        @JsonProperty("codigo_rota")
        String codigoRota) {
}
