package com.mxs.rota.resposta;

import lombok.Builder;

/**
 * Classe responsável por representar a resposta da atualização de uma Parada no controlador.
 */
@Builder
public record ParadaControladorAtualizarResposta(String codigo) {
}
