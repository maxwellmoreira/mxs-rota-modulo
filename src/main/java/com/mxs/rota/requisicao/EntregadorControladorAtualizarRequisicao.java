package com.mxs.rota.requisicao;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import lombok.Builder;

/**
 * Classe responsável por representar a requisição de atualização de um Entregador no controlador.
 */
@Builder
public record EntregadorControladorAtualizarRequisicao(
        @NotBlank(message = "Código do entregador é de preenchimento obrigatório")
        @JsonProperty("codigo")
        String codigo,
        @NotBlank(message = "Nome do usuário é de preenchimento obrigatório")
        @JsonProperty("user_name")
        String username,
        @NotBlank(message = "E-mail é de preenchimento obrigatório")
        @JsonProperty("email")
        String email) {
}
