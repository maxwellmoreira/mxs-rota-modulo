package com.mxs.rota.requisicao;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import lombok.Builder;

/**
 * Classe responsável por representar a requisição de criação de uma Parada no controlador.
 */
@Builder
public record ParadaControladorCriarRequisicao(
        @NotBlank(message = "Descrição da parada é de preenchimento obrigatório")
        @JsonProperty("descricao")
        String descricao,
        @NotBlank(message = "Endereço da parada é de preenchimento obrigatório")
        @JsonProperty("endereco")
        String endereco,
        @NotBlank(message = "Latitude da parada é de preenchimento obrigatório")
        @JsonProperty("latitude")
        String latitude,
        @NotBlank(message = "Longitude da parada é de preenchimento obrigatório")
        @JsonProperty("longitude")
        String longitude,
        @NotBlank(message = "Raio de entrega da parada é de preenchimento obrigatório")
        @JsonProperty("raio_entrega")
        String raioEntrega,
        @NotBlank(message = "Status da parada é de preenchimento obrigatório")
        @JsonProperty("status_parada")
        String statusParada,
        @NotBlank(message = "Código da rota é de preenchimento obrigatório")
        @JsonProperty("codigo_rota")
        String codigoRota) {
}
