package com.mxs.rota.requisicao;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;

@Builder
public record TrajetoControladorCriarRequisicao(
        @JsonProperty("codigo_parada")
        String codigoParada,
        @JsonProperty("status_parada")
        String statusParada,
        @JsonProperty("latitude")
        String latitude,
        @JsonProperty("longitude")
        String longitude,
        @JsonProperty("codigo_entregador")
        String codigoEntregador) {
}
