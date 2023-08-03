package com.mxs.rota.requisicao;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import lombok.Builder;

@Builder
public record EntregadorControladorExcluirRequisicao(
        @NotBlank(message = "Código do entregador é de preenchimento obrigatório")
        @JsonProperty("codigo")
        String codigo) {
}
