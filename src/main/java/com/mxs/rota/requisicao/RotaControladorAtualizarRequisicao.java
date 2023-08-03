package com.mxs.rota.requisicao;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import lombok.Builder;

/**
 * Classe responsável por representar a requisição de atualização de uma Rota no controlador.
 */
@Builder
public record RotaControladorAtualizarRequisicao(
        @NotBlank(message = "Código da rota é de preenchimento obrigatório")
        @JsonProperty("codigo")
        String codigo,
        @NotBlank(message = "Data da rota é de preenchimento obrigatório")
        @JsonProperty("data")
        String data,
        @NotBlank(message = "Status da rota é de preenchimento obrigatório")
        @JsonProperty("status_rota")
        String statusRota
) {
}
