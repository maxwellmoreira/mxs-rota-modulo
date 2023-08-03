package com.mxs.rota.conversor;

import com.mxs.rota.modelo.TrajetoModelo;
import com.mxs.rota.requisicao.TrajetoControladorCriarRequisicao;
import com.mxs.rota.tipo.StatusParadaTipo;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class TrajetoConversor {

    public TrajetoModelo controladorCriarRequisicaoParaModelo(TrajetoControladorCriarRequisicao trajetoControladorCriarRequisicao) {
        return TrajetoModelo
                .builder()
                .codigoParada(trajetoControladorCriarRequisicao.codigoParada())
                .statusParada(StatusParadaTipo.valueOf(trajetoControladorCriarRequisicao.statusParada()).name())
                .codigoEntregador(trajetoControladorCriarRequisicao.codigoEntregador())
                .latitude(trajetoControladorCriarRequisicao.latitude())
                .longitude(trajetoControladorCriarRequisicao.longitude())
                .quando(UUID.randomUUID().toString())
                .build();
    }
}
