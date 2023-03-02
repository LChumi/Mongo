package com.chumi.mongo.repository;

import com.chumi.mongo.models.Restaurante;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface RestauranteRepository extends MongoRepository<Restaurante,Long> {
}
