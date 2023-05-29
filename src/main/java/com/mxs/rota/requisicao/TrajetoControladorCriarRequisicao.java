package com.mxs.rota.requisicao;

import lombok.Builder;

@Builder
public record TrajetoControladorCriarRequisicao(
        String codigoParada,
        String statusParada,
        String latitude,
        String longitude,
        String codigoEntregador,
        String quando) {
}
