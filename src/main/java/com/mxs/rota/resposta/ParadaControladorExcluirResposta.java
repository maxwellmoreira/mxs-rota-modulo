package com.mxs.rota.resposta;

import lombok.Builder;

/**
 * Classe responsável por representar a resposta da exclusão de uma Parada no controlador.
 */
@Builder
public record ParadaControladorExcluirResposta(String codigo) {
}
