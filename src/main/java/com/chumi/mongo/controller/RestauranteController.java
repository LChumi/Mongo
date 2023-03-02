package com.chumi.mongo.controller;

import com.chumi.mongo.models.Restaurante;
import com.chumi.mongo.services.RestauranteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("mongo/restaurante")
public class RestauranteController {
    @Autowired
    RestauranteService restauranteService;

    @GetMapping("/listar")
    public ResponseEntity<List<Restaurante>> listarProductos() {
        return new ResponseEntity<>(restauranteService.findByAll(),
                HttpStatus.OK);
    }

    @PostMapping("/crear")
    public ResponseEntity<Restaurante> crearProducto(@RequestBody Restaurante p) {
        return new ResponseEntity<>(restauranteService.save(p),
                HttpStatus.CREATED);
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<Restaurante> eliminarProducto(@PathVariable Long id) {
        restauranteService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/actualizar/{id}")
    public ResponseEntity<Restaurante> actualizarProducto(@PathVariable Long id, @RequestBody Restaurante p) {
        Restaurante restauranteEncontrado = restauranteService.findById(id);
        if (restauranteEncontrado == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            try {
                restauranteEncontrado.setNombre(p.getNombre());
                restauranteEncontrado.setTelefono(p.getTelefono());
                restauranteEncontrado.setCorreo(p.getCorreo());
                restauranteEncontrado.setDireccion(p.getDireccion());
                restauranteEncontrado.setClientes(p.getClientes());
                restauranteEncontrado.setCartas(p.getCartas());
                
                return new ResponseEntity<>(restauranteService.save(p), HttpStatus.OK);
            } catch (DataAccessException e) {
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }
    }
}
