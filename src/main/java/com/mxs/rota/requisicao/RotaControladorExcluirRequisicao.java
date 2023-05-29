package com.mxs.rota.requisicao;

import jakarta.validation.constraints.NotBlank;
import lombok.Builder;

/**
 * Classe responsável por representar a requisição de exclusão de uma Rota no controlador.
 */
@Builder
public record RotaControladorExcluirRequisicao(
        @NotBlank(message = "Código da rota é de preenchimento obrigatório")
        String codigo
) {
}
