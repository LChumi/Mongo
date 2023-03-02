package com.chumi.mongo.models;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "Cliente")
public class Cliente {

    private String nombre;
    private String apellido;
    private String cedula;
    private String corre;
}
