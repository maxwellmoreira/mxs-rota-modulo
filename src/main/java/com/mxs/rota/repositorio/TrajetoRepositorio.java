package com.mxs.rota.repositorio;

import com.mxs.rota.modelo.TrajetoModelo;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TrajetoRepositorio extends MongoRepository<TrajetoModelo, String> {
}
