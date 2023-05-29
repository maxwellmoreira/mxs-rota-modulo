package com.mxs.rota.resposta;

import com.mxs.rota.dto.ParadaDto;
import lombok.Builder;

import java.util.List;

/**
 * Classe responsável por representar a resposta de uma listagem de Rotas no controlador.
 */
@Builder
public record RotaControladorObterResposta(
        String codigo,
        String data,
        String statusRota,
        List<ParadaDto> paradas) {
}
