package com.mxs.rota.requisicao;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import lombok.Builder;

/**
 * Classe responsável por representar a requisição de exclusão de uma Parada no controlador.
 */
@Builder
public record ParadaControladorExcluirRequisicao(
        @NotBlank(message = "Código da parada é de preenchimento obrigatório")
        @JsonProperty("codigo")
        String codigo) {
}
