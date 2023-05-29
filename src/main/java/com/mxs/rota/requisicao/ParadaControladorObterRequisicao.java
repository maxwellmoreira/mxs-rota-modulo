package com.mxs.rota.requisicao;

import jakarta.validation.constraints.NotBlank;
import lombok.Builder;

/**
 * Classe responsável por representar a requisição de filtro para busca de Paradas no controlador.
 */
@Builder
public record ParadaControladorObterRequisicao(
        @NotBlank(message = "Código da parada é de preenchimento obrigatório")
        String codigo,
        @NotBlank(message = "Descrição da parada é de preenchimento obrigatório")
        String descricao,
        @NotBlank(message = "Endereço da parada é de preenchimento obrigatório")
        String endereco,
        @NotBlank(message = "Latitude da parada é de preenchimento obrigatório")
        String latitude,
        @NotBlank(message = "Longitude da parada é de preenchimento obrigatório")
        String longitude,
        @NotBlank(message = "Raio de entrega da parada é de preenchimento obrigatório")
        String raioEntrega,
        @NotBlank(message = "Status da parada é de preenchimento obrigatório")
        String statusParada,
        @NotBlank(message = "Código da rota é de preenchimento obrigatório")
        String codigoRota) {
}
