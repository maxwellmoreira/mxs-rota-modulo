package com.mxs.rota.resposta;

import lombok.Builder;

/**
 * Classe responsável por representar a resposta da criação de uma Rota no controlador.
 */
@Builder
public record RotaControladorCriarResposta(String codigo) {
}
