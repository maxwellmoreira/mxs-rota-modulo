package com.mxs.rota.resposta;

import lombok.Builder;

/**
 * Classe responsável por representar a resposta da exclusão de uma Rota no controlador.
 */
@Builder
public record RotaControladorExcluirResposta(String codigo) {
}
