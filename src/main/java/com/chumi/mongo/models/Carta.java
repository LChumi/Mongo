package com.chumi.mongo.models;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@Document(collection = "Carta")
public class Carta {

    private String nombre;
    private String categoria;
    private Long cantidad;

    private List<Plato> platos;

}
