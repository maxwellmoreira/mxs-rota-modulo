package com.mxs.rota.conversor;

import com.mxs.rota.modelo.RotaModelo;
import com.mxs.rota.requisicao.RotaControladorAtualizarRequisicao;
import com.mxs.rota.resposta.RotaControladorObterResposta;
import com.mxs.rota.tipo.StatusRotaTipo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Classe responsável por converter requisições, respostas e dto's relacionados com a entidade Rota.
 */
@Component
public class RotaConversor {

    @Autowired
    private ParadaConversor paradaConversor;

    public List<RotaControladorObterResposta> modeloListaParaControladorObterRespostaLista(List<RotaModelo> modeloLista) {
        return modeloLista.stream().map(this::modeloParaControladorObterResposta).collect(Collectors.toList());
    }

    public RotaControladorObterResposta modeloParaControladorObterResposta(RotaModelo rotaModelo) {
        return RotaControladorObterResposta
                .builder()
                .codigo(rotaModelo.getCodigo())
                .data(rotaModelo.getData().toString())
                .statusRota(rotaModelo.getStatusRotaTipo().name())
                .paradas(this.paradaConversor.modeloListaParaDtoLista(rotaModelo.getParadaModeloLista()))
                .build();
    }

    public RotaModelo modeloParaControladorAtualizarRequisicao(RotaControladorAtualizarRequisicao rotaControladorAtualizarRequisicao,
                                                               RotaModelo rotaEncontradaNoBanco) {
        RotaModelo modelo = rotaEncontradaNoBanco;
        modelo.setData(LocalDate.parse(rotaControladorAtualizarRequisicao.data()));
        modelo.setStatusRotaTipo(StatusRotaTipo.valueOf(rotaControladorAtualizarRequisicao.statusRota()));
        return modelo;
    }
}
