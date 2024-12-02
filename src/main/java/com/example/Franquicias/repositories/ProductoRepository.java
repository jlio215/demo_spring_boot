package com.example.Franquicias.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.Franquicias.models.Producto;

import java.util.List;

@Repository
public interface ProductoRepository extends MongoRepository<Producto, String> {

    // Buscar productos por sucursalId
    List<Producto> findBySucursalId(String sucursalId);
}
