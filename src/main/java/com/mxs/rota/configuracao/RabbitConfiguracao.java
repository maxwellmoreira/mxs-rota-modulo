package com.mxs.rota.configuracao;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import static com.mxs.rota.padrao.FilaPadrao.OCORRENCIA;
import static com.mxs.rota.padrao.FilaPadrao.TRAJETO;

@Configuration
public class RabbitConfiguracao {
    @Bean
    public Queue definirFilaTrajeto() {
        return new Queue(TRAJETO, false);
    }

    @Bean
    public Queue definirFilaOcorrencia() {
        return new Queue(OCORRENCIA, false);
    }
}
