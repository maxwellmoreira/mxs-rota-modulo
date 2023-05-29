package com.mxs.rota.resposta;

import lombok.Builder;

/**
 * Classe responsável por representar a resposta da criação de uma Parada no controlador.
 */
@Builder
public record ParadaControladorCriarResposta(String codigo) {
}
