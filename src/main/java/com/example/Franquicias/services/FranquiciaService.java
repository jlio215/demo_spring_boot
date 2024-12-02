package com.example.Franquicias.services;

import com.example.Franquicias.models.Franquicia;
import com.example.Franquicias.models.Sucursal;
import com.example.Franquicias.repositories.FranquiciaRepository;
import com.example.Franquicias.repositories.SucursalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FranquiciaService {

    private final FranquiciaRepository franquiciaRepository;
    private final SucursalRepository sucursalRepository;

    @Autowired
    public FranquiciaService(FranquiciaRepository franquiciaRepository, SucursalRepository sucursalRepository) {
        this.franquiciaRepository = franquiciaRepository;
        this.sucursalRepository = sucursalRepository;
    }

    // Crear una nueva franquicia
    public Franquicia createFranquicia(Franquicia franquicia) {
        return franquiciaRepository.save(franquicia);
    }

    // Obtener todas las franquicias
    public List<Franquicia> getAllFranquicias() {
        return franquiciaRepository.findAll();
    }

    // Obtener una franquicia por ID
    public Franquicia getFranquiciaById(String id) {
        return franquiciaRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Franquicia no encontrada"));
    }

    // Agregar sucursal a una franquicia
    public Sucursal addSucursalToFranquicia(String franquiciaId, Sucursal sucursal) {
        Franquicia franquicia = getFranquiciaById(franquiciaId);
        sucursal.setFranquiciaId(franquicia.getId());
        Sucursal savedSucursal = sucursalRepository.save(sucursal);

        franquicia.getSucursales().add(savedSucursal);
        franquiciaRepository.save(franquicia);

        return savedSucursal;
    }

    // Actualizar una franquicia
    public Franquicia updateFranquicia(String id, Franquicia updatedFranquicia) {
        Franquicia franquicia = getFranquiciaById(id);
        franquicia.setNombre(updatedFranquicia.getNombre());
        return franquiciaRepository.save(franquicia);
    }

    // Eliminar una franquicia
    public void deleteFranquicia(String id) {
        franquiciaRepository.deleteById(id);
    }

    
}
