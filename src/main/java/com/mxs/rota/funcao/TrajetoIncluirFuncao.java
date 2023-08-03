package com.mxs.rota.funcao;

import com.mxs.rota.conversor.TrajetoConversor;
import com.mxs.rota.requisicao.TrajetoControladorCriarRequisicao;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static com.mxs.rota.padrao.FilaPadrao.TRAJETO;

/**
 * Classe responsável pelo caso de uso de inclusão da entidade Trajeto.
 */
@Service
public class TrajetoIncluirFuncao {

    @Autowired
    private TrajetoConversor trajetoConversor;
    @Autowired
    private RabbitTemplate rabbitTemplate;

    /**
     * Método responsável por incluir um Trajeto.
     *
     * @param trajetoControladorCriarRequisicao objeto contendo os atributos do Trajeto
     */
    public void criarTrajeto(TrajetoControladorCriarRequisicao trajetoControladorCriarRequisicao) {
        var trajetoModelo = this.trajetoConversor.controladorCriarRequisicaoParaModelo(trajetoControladorCriarRequisicao);
        this.rabbitTemplate.convertAndSend(TRAJETO, trajetoModelo);
    }
}
