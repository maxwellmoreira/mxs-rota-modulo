package com.mxs.rota.requisicao;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;

/**
 * Classe responsável por representar a requisição de filtro para busca de Entregador no controlador.
 */
@Builder
public record EntregadorControladorObterRequisicao(
        @JsonProperty("codigo")
        String codigo,
        @JsonProperty("user_name")
        String username,
        @JsonProperty("email")
        String email) {
}
