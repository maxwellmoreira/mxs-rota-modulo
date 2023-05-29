package com.mxs.rota;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class MxsRotaModuloApplication {
	public static void main(String[] args) {
		SpringApplication.run(MxsRotaModuloApplication.class, args);
	}
}
