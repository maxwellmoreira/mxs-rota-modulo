package com.mxs.rota.resposta;

import lombok.Builder;

/**
 * Classe responsável por representar a resposta da atualização de uma Rota no controlador.
 */
@Builder
public record RotaControladorAtualizarResposta(String codigo) {
}
