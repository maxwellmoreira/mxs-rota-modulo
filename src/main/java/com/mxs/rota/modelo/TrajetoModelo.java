package com.mxs.rota.modelo;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Classe responsável por representar um Trajeto durante uma entrega.
 */
@Getter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "trajeto")
public class TrajetoModelo {
    @Id
    private String codigoParada;
    private String statusParada;
    private String latitude;
    private String longitude;
    private String codigoEntregador;
    private String quando;
}
