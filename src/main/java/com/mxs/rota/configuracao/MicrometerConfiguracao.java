package com.mxs.rota.configuracao;

import io.micrometer.core.instrument.MeterRegistry;
import io.micrometer.core.instrument.composite.CompositeMeterRegistry;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MicrometerConfiguracao {
    @Bean
    public MeterRegistry getMeterRegistry() {
        CompositeMeterRegistry compositeMeterRegistry = new CompositeMeterRegistry();
        return compositeMeterRegistry;
    }
}
