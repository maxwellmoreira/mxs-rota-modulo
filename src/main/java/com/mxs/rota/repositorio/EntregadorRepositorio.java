package com.mxs.rota.repositorio;

import com.mxs.rota.modelo.EntregadorModelo;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * Classe responsável por representar o repositório da entidade Entregador.
 */
@Repository
public interface EntregadorRepositorio extends CrudRepository<EntregadorModelo, Long>, JpaSpecificationExecutor<EntregadorModelo> {
    Optional<EntregadorModelo> findByCodigoEquals(String codigo);
}
