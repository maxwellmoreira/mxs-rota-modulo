package com.mxs.rota.consumidor;

import com.mxs.rota.modelo.TrajetoModelo;
import com.mxs.rota.repositorio.TrajetoRepositorio;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import static com.mxs.rota.padrao.FilaPadrao.TRAJETO;

@Component
public class TrajetoConsumidor {

    @Autowired
    private TrajetoRepositorio trajetoRepositorio;

    @RabbitListener(queues = TRAJETO)
    public void consume(TrajetoModelo trajetoModelo) {
        this.trajetoRepositorio.save(trajetoModelo);
    }
}
