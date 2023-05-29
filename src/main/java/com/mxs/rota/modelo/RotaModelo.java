package com.mxs.rota.modelo;

import com.mxs.rota.tipo.StatusRotaTipo;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

/**
 * Classe responsável por representar a entidade Rota.
 */
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "rota")
public final class RotaModelo extends AuditoriaModelo {
    @Column(name = "data", nullable = false)
    private LocalDate data;
    @Enumerated(EnumType.STRING)
    @Column(name = "status_rota", nullable = false)
    private StatusRotaTipo statusRotaTipo;
    @OneToMany(mappedBy = "rotaModelo", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<ParadaModelo> paradaModeloLista;
}
