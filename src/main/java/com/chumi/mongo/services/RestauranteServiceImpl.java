package com.chumi.mongo.services;

import com.chumi.mongo.models.Restaurante;
import com.chumi.mongo.repository.RestauranteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

@Service
public class RestauranteServiceImpl extends GenericServiceImpl<Restaurante,Long> implements RestauranteService{

    @Autowired
    private RestauranteRepository restauranteRepository;

    @Override
    public CrudRepository<Restaurante, Long> getDao() {
        return restauranteRepository;
    }
}
