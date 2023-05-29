package com.mxs.rota.requisicao;

import jakarta.validation.constraints.NotBlank;
import lombok.Builder;

/**
 * Classe responsável por representar a requisição de criação de um Entregador no controlador.
 */
@Builder
public record EntregadorControladorCriarRequisicao(
        @NotBlank(message = "Nome do usuário é de preenchimento obrigatório")
        String username,
        @NotBlank(message = "E-mail é de preenchimento obrigatório")
        String email) {
}
