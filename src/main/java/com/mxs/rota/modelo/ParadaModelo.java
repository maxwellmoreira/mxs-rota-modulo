package com.mxs.rota.modelo;

import com.mxs.rota.tipo.StatusParadaTipo;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

/**
 * Classe responsável por representar a entidade Parada.
 */
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "parada")
public final class ParadaModelo extends AuditoriaModelo {
    @Column(name = "descricao", nullable = false, length = 256)
    private String descricao;
    @Column(name = "endereco", nullable = false, length = 256)
    private String endereco;
    @Column(name = "latitude", nullable = false)
    private double latitude;
    @Column(name = "longitude", nullable = false)
    private double longitude;
    @Column(name = "raio_entrega", nullable = false)
    private int raioEntrega;
    @Enumerated(EnumType.STRING)
    @Column(name = "status_parada", nullable = false)
    private StatusParadaTipo statusParadaTipo;
    @ManyToOne
    @JoinColumn(name = "rota_id", nullable = false)
    private RotaModelo rotaModelo;
    @ManyToOne
    @JoinColumn(name = "entregador_id")
    private EntregadorModelo entregadorModelo;
}
