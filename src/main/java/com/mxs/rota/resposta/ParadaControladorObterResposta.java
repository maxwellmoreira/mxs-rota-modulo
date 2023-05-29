package com.mxs.rota.resposta;

import lombok.Builder;

/**
 * Classe responsável por representar a resposta de uma listagem de Paradas no controlador.
 */
@Builder
public record ParadaControladorObterResposta(
        String codigo,
        String descricao,
        String endereco,
        String latitude,
        String longitude,
        String raioEntrega,
        String statusParada,
        String codigoRota) {
}
