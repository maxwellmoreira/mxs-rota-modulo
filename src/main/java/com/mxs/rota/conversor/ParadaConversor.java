package com.mxs.rota.conversor;

import com.mxs.rota.dto.ParadaDto;
import com.mxs.rota.modelo.ParadaModelo;
import com.mxs.rota.modelo.RotaModelo;
import com.mxs.rota.requisicao.ParadaControladorAtualizarRequisicao;
import com.mxs.rota.requisicao.ParadaControladorCriarRequisicao;
import com.mxs.rota.resposta.ParadaControladorObterResposta;
import com.mxs.rota.tipo.StatusParadaTipo;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Classe responsável por converter requisições, respostas e dto's relacionados com a entidade Parada.
 */
@Component
public class ParadaConversor {

    public List<ParadaDto> modeloListaParaDtoLista(List<ParadaModelo> paradaModeloLista) {
        return paradaModeloLista.stream().map(this::modeloParaDto).collect(Collectors.toList());
    }

    public ParadaDto modeloParaDto(ParadaModelo paradaModelo) {
        return ParadaDto
                .builder()
                .codigo(paradaModelo.getCodigo())
                .descricao(paradaModelo.getDescricao())
                .endereco(paradaModelo.getEndereco())
                .latitude(Double.toString(paradaModelo.getLatitude()))
                .longitude(Double.toString(paradaModelo.getLongitude()))
                .raioEntrega(Integer.toString(paradaModelo.getRaioEntrega()))
                .statusParada(paradaModelo.getStatusParadaTipo().name())
                .build();
    }

    public ParadaModelo controladorCriarRequisicaoParaModelo(
            ParadaControladorCriarRequisicao paradaControladorCriarRequisicao, RotaModelo rotaModelo) {
        return ParadaModelo
                .builder()
                .descricao(paradaControladorCriarRequisicao.descricao())
                .endereco(paradaControladorCriarRequisicao.endereco())
                .latitude(Double.parseDouble(paradaControladorCriarRequisicao.latitude()))
                .longitude(Double.parseDouble(paradaControladorCriarRequisicao.longitude()))
                .raioEntrega(Integer.parseInt(paradaControladorCriarRequisicao.raioEntrega()))
                .statusParadaTipo(StatusParadaTipo.valueOf(paradaControladorCriarRequisicao.statusParada()))
                .rotaModelo(rotaModelo)
                .build();
    }

    public List<ParadaControladorObterResposta> modeloListaParaControladorObterRespostaLista(List<ParadaModelo> paradaModeloLista) {
        return paradaModeloLista.stream().map(this::modeloParaControladorObterResposta).collect(Collectors.toList());
    }

    public ParadaControladorObterResposta modeloParaControladorObterResposta(ParadaModelo paradaModelo) {
        return ParadaControladorObterResposta
                .builder()
                .codigo(paradaModelo.getCodigo())
                .descricao(paradaModelo.getDescricao())
                .endereco(paradaModelo.getEndereco())
                .latitude(Double.toString(paradaModelo.getLatitude()))
                .longitude(Double.toString(paradaModelo.getLongitude()))
                .raioEntrega(Integer.toString(paradaModelo.getRaioEntrega()))
                .statusParada(paradaModelo.getStatusParadaTipo().name())
                .codigoRota(paradaModelo.getRotaModelo().getCodigo())
                .build();
    }

    public ParadaModelo controladorAtualizarRequisicaoParaModelo(ParadaControladorAtualizarRequisicao paradaControladorAtualizarRequisicao,
            ParadaModelo paradaEncontradaNoBanco, RotaModelo rotaEncontraNoBanco) {
        ParadaModelo paradaModelo = paradaEncontradaNoBanco;
        paradaModelo.setDescricao(paradaControladorAtualizarRequisicao.descricao());
        paradaModelo.setEndereco(paradaControladorAtualizarRequisicao.endereco());
        paradaModelo.setLatitude(Double.parseDouble(paradaControladorAtualizarRequisicao.latitude()));
        paradaModelo.setLongitude(Double.parseDouble(paradaControladorAtualizarRequisicao.longitude()));
        paradaModelo.setRaioEntrega(Integer.parseInt(paradaControladorAtualizarRequisicao.raioEntrega()));
        paradaModelo.setRotaModelo(rotaEncontraNoBanco);
        return paradaModelo;
    }
}
