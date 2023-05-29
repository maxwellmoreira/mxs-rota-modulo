package com.mxs.rota.repositorio;

import com.mxs.rota.modelo.ParadaModelo;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * Classe responsável por representar o repositório da entidade Parada.
 */
@Repository
public interface ParadaRepositorio extends CrudRepository<ParadaModelo, Long>, JpaSpecificationExecutor<ParadaModelo> {
    Optional<ParadaModelo> findByCodigoEquals(String codigo);
}
