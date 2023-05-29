package com.mxs.rota.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@Builder
@AllArgsConstructor
public class RotaDto {
    private String data;
    private String statusRota;
    private List<ParadaDto> paradas;
}
