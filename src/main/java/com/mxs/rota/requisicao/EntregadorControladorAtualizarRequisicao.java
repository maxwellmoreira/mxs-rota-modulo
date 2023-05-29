package com.mxs.rota.requisicao;

import jakarta.validation.constraints.NotBlank;
import lombok.Builder;

/**
 * Classe responsável por representar a requisição de atualização de um Entregador no controlador.
 */
@Builder
public record EntregadorControladorAtualizarRequisicao(
        @NotBlank(message = "Código do entregador é de preenchimento obrigatório")
        String codigo,
        @NotBlank(message = "Nome do usuário é de preenchimento obrigatório")
        String username,
        @NotBlank(message = "E-mail é de preenchimento obrigatório")
        String email) {
}
