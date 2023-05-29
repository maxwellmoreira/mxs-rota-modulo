package com.mxs.rota.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor
public class ParadaDto {
    private String codigo;
    private String descricao;
    private String endereco;
    private String latitude;
    private String longitude;
    private String raioEntrega;
    private String statusParada;
}
