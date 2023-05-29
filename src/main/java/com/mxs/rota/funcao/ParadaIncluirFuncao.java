package com.mxs.rota.funcao;

import com.mxs.rota.conversor.ParadaConversor;
import com.mxs.rota.fachada.RotaFachada;
import com.mxs.rota.repositorio.ParadaRepositorio;
import com.mxs.rota.requisicao.ParadaControladorCriarRequisicao;
import com.mxs.rota.resposta.ParadaControladorCriarResposta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Classe responsável pelo caso de uso de inclusão da entidade Parada.
 */
@Service
public class ParadaIncluirFuncao {

    @Autowired
    private RotaFachada rotaFachada;
    @Autowired
    private ParadaConversor paradaConversor;
    @Autowired
    private ParadaRepositorio paradaRepositorio;

    /**
     * Método responsável por incluir uma Parada.
     *
     * @param paradaControladorCriarRequisicao objeto contendo os atributos da Parada
     * @return objeto contendo o código da Parada incluída
     */
    public ParadaControladorCriarResposta criarParada(ParadaControladorCriarRequisicao paradaControladorCriarRequisicao) {

        var rotaModelo = this.rotaFachada.obterRotaPorCodigo(paradaControladorCriarRequisicao.codigoRota());

        var paradaModelo = this.paradaConversor.controladorCriarRequisicaoParaModelo(paradaControladorCriarRequisicao, rotaModelo);

        var codigoParada = this.paradaRepositorio.save(paradaModelo).getCodigo();

        return ParadaControladorCriarResposta.builder().codigo(codigoParada).build();
    }
}
