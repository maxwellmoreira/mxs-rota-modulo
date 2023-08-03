package com.mxs.rota.modelo;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;

/**
 * Classe responsável por representar um Trajeto durante uma entrega.
 */
@Getter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "trajeto")
public class TrajetoModelo implements Serializable {

    private static final long serialVersionUID = -8467744052473547615L;

    @Id
    private String codigoParada;
    private String statusParada;
    private String codigoEntregador;
    private String latitude;
    private String longitude;
    private String quando;
}
