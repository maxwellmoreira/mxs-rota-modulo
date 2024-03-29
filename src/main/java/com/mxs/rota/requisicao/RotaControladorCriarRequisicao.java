package com.mxs.rota.requisicao;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import lombok.Builder;

/**
 * Classe responsável por representar a requisição de criação de uma Rota no controlador.
 */
@Builder
public record RotaControladorCriarRequisicao(
        @NotBlank(message = "Data da rota é de preenchimento obrigatório")
        @JsonProperty("data")
        String data,
        @NotBlank(message = "Status da rota é de preenchimento obrigatório")
        @JsonProperty("status_rota")
        String statusRota) {
}
