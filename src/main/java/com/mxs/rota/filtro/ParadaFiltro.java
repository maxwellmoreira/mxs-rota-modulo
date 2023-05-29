package com.mxs.rota.filtro;

import com.mxs.rota.modelo.ParadaModelo;
import com.mxs.rota.modelo.RotaModelo;
import com.mxs.rota.tipo.StatusParadaTipo;
import org.springframework.data.jpa.domain.Specification;

/**
 * Classe responsável pelos filtros que poderão ser utilizados em consultas da entidade Parada.
 */
public class ParadaFiltro {
    // CODIGO
    public static Specification<ParadaModelo> filtrarPorCodigo(String codigo) {
        return (root, query, builder) -> builder.equal(root.get("codigo"), codigo);
    }

    // DESCRICAO
    public static Specification<ParadaModelo> filtrarPorDescricao(String descricao) {
        return (root, query, builder) -> builder.equal(root.get("descricao"), descricao);
    }

    // ENDERECO
    public static Specification<ParadaModelo> filtrarPorEndereco(String endereco) {
        return (root, query, builder) -> builder.equal(root.get("endereco"), endereco);
    }

    // LATITUDE
    public static Specification<ParadaModelo> filtrarPorLatitude(double latitude) {
        return (root, query, builder) -> builder.equal(root.get("latitude"), latitude);
    }

    // LONGITUDE
    public static Specification<ParadaModelo> filtrarPorLongitude(double longitude) {
        return (root, query, builder) -> builder.equal(root.get("longitude"), longitude);
    }

    // RAIO ENTREGA
    public static Specification<ParadaModelo> filtrarPorRaioEntrega(int raioEntrega) {
        return (root, query, builder) -> builder.equal(root.get("raioEntrega"), raioEntrega);
    }

    // STATUS PARADA
    public static Specification<ParadaModelo> filtrarPorStatusParada(StatusParadaTipo statusParadaTipo) {
        return (root, query, builder) -> builder.equal(root.get("statusParadaTipo"), statusParadaTipo);
    }

    // ROTA
    public static Specification<ParadaModelo> filtrarPorRota(RotaModelo rotaModelo) {
        return (root, query, builder) -> builder.equal(root.get("rota"), rotaModelo);
    }

    // STATUS
    public static Specification<ParadaModelo> filtrarPorStatus(String status) {
        return (root, query, builder) -> builder.equal(root.get("status"), status);
    }
}
