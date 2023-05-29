package com.mxs.rota.resposta;

import com.mxs.rota.dto.AtendimentoDto;
import lombok.Builder;

import java.util.List;

/**
 * Classe responsável por representar a resposta de uma listagem de Entregadores no controlador.
 */
@Builder
public record EntregadorControladorObterResposta(
        String username,
        String email,
        List<AtendimentoDto> atendimentos) {
}
