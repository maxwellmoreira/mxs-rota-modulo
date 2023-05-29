package com.mxs.rota.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor
public class AtendimentoDto {
    private String latitude;
    private String longitude;
    private RotaDto rota;
}
