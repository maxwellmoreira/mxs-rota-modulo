package com.mxs.rota.funcao;

import com.mxs.rota.conversor.ParadaConversor;
import com.mxs.rota.modelo.RotaModelo;
import com.mxs.rota.repositorio.RotaRepositorio;
import com.mxs.rota.requisicao.RotaControladorCriarRequisicao;
import com.mxs.rota.requisicao.TrajetoControladorCriarRequisicao;
import com.mxs.rota.resposta.RotaControladorCriarResposta;
import com.mxs.rota.tipo.StatusRotaTipo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

/**
 * Classe responsável pelo caso de uso de inclusão da entidade Rota.
 */
@Service
public class RotaIncluirFuncao {

    @Autowired
    private ParadaConversor paradaConversor;
    @Autowired
    private RotaRepositorio rotaRepositorio;
    @Autowired
    private TrajetoIncluirFuncao trajetoIncluirFuncao;

    /**
     * Método responsável por incluir uma Rota.
     *
     * @param rotaControladorCriarRequisicao objeto contendo os atributos da Rota
     * @return objeto contendo o código de identificação da Rota incluída
     */
    public RotaControladorCriarResposta criarRota(RotaControladorCriarRequisicao rotaControladorCriarRequisicao) {

        var rotaModelo =
                RotaModelo
                        .builder()
                        .data(LocalDate.parse(rotaControladorCriarRequisicao.data()))
                        .statusRotaTipo(StatusRotaTipo.valueOf(rotaControladorCriarRequisicao.statusRota()))
                        .build();

        var codigoRota = this.rotaRepositorio.save(rotaModelo).getCodigo();

        return RotaControladorCriarResposta
                .builder()
                .codigo(codigoRota)
                .build();
    }
}
