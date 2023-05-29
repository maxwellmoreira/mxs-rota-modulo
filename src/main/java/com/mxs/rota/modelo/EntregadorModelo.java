package com.mxs.rota.modelo;

import com.mxs.rota.tipo.StatusEntregadorTipo;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

/**
 * Classe responsável por representar a entidade Entregador.
 */
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "entregador")
public final class EntregadorModelo extends AuditoriaModelo {

    @Column(name = "username", nullable = false, length = 20)
    private String username;
    @Column(name = "email", nullable = false, length = 256)
    private String email;
    @Enumerated(EnumType.STRING)
    @Column(name = "status_entregador", nullable = false, length = 7)
    private StatusEntregadorTipo statusEntregadorTipo;
    @OneToMany(mappedBy = "entregadorModelo", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<ParadaModelo> paradaModeloLista;

    public void ficarOnline() {
        this.statusEntregadorTipo = StatusEntregadorTipo.ONLINE;
    }

    public void ficarOffline() {
        this.statusEntregadorTipo = StatusEntregadorTipo.OFFLINE;
    }
}
