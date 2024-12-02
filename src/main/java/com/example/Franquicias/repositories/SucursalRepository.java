package com.example.Franquicias.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.Franquicias.models.Sucursal;

import java.util.List;

@Repository
public interface SucursalRepository extends MongoRepository<Sucursal, String> {

    // Buscar sucursales por franquiciaId
    List<Sucursal> findByFranquiciaId(String franquiciaId);
}
