package com.mxs.rota.funcao;

import com.mxs.rota.modelo.TrajetoModelo;
import com.mxs.rota.repositorio.TrajetoRepositorio;
import com.mxs.rota.requisicao.TrajetoControladorCriarRequisicao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TrajetoIncluirFuncao {

    @Autowired
    private TrajetoRepositorio trajetoRepositorio;
    
    public void criarTrajeto(TrajetoControladorCriarRequisicao trajetoControladorCriarRequisicao) {

        TrajetoModelo trajetoModelo =
                TrajetoModelo
                        .builder()
                        .codigoEntregador(trajetoControladorCriarRequisicao.codigoEntregador())
                        .codigoParada(trajetoControladorCriarRequisicao.codigoParada())
                        .latitude(trajetoControladorCriarRequisicao.latitude())
                        .longitude(trajetoControladorCriarRequisicao.longitude())
                        .statusParada(trajetoControladorCriarRequisicao.statusParada())
                        .quando(trajetoControladorCriarRequisicao.quando())
                        .build();
        this.trajetoRepositorio.save(trajetoModelo);
    }
}
