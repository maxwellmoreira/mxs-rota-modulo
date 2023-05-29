package com.mxs.rota.repositorio;

import com.mxs.rota.modelo.RotaModelo;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * Classe responsável por representar o repositório da entidade Rota.
 */
@Repository
public interface RotaRepositorio extends CrudRepository<RotaModelo, Long>, JpaSpecificationExecutor<RotaModelo> {
    Optional<RotaModelo> findByCodigoEquals(String codigo);
}
