package com.chumi.mongo.models;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@Document(collection = "Restaurante")
public class Restaurante {

    private Long id;
    private String nombre;
    private String telefono;
    private String correo;
    private String direccion;

    private List<Cliente> clientes;
    private List<Carta> cartas;


}
