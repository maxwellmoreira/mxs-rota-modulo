package com.mxs.rota.filtro;

import com.mxs.rota.modelo.RotaModelo;
import com.mxs.rota.tipo.StatusRotaTipo;
import org.springframework.data.jpa.domain.Specification;

import java.time.LocalDate;

/**
 * Classe responsável pelos filtros que poderão ser utilizados em consultas da entidade Rota.
 */
public class RotaFiltro {
    // CODIGO
    public static Specification<RotaModelo> filtrarPorCodigo(String codigo) {
        return (root, query, builder) -> builder.equal(root.get("codigo"), codigo);
    }

    // DATA
    public static Specification<RotaModelo> filtrarPorData(LocalDate data) {
        return (root, query, builder) -> builder.equal(root.get("data"), data);
    }

    // STATUS ROTA
    public static Specification<RotaModelo> filtrarPorStatusRota(StatusRotaTipo statusRotaTipo) {
        return (root, query, builder) -> builder.equal(root.get("statusRotaTipo"), statusRotaTipo);
    }

    // STATUS
    public static Specification<RotaModelo> filtrarPorStatus(String status) {
        return (root, query, builder) -> builder.equal(root.get("status"), status);
    }
}
