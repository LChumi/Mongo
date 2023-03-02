package com.chumi.mongo.models;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "Plato")
public class Plato {

    private String nombrePlato;
    private String descripcion;
    private double precio;
}
