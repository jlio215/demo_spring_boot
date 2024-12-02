package com.example.Franquicias.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.Franquicias.models.Franquicia;

@Repository
public interface FranquiciaRepository extends MongoRepository<Franquicia, String> {
}
