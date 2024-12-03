package com.example.Franquicias.controllers;

import com.example.Franquicias.models.Franquicia;
import com.example.Franquicias.models.Sucursal;
import com.example.Franquicias.services.FranquiciaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/franquicias")
public class FranquiciaController {

    private final FranquiciaService franquiciaService;

    @Autowired
    public FranquiciaController(FranquiciaService franquiciaService) {
        this.franquiciaService = franquiciaService;
    }

    @PostMapping
    public Franquicia createFranquicia(@RequestBody Franquicia franquicia) {
        return franquiciaService.createFranquicia(franquicia);
    }

    @GetMapping
    public List<Franquicia> getAllFranquicias() {
        return franquiciaService.getAllFranquicias();
    }

    @GetMapping("/{id}")
    public Franquicia getFranquiciaById(@PathVariable String id) {
        return franquiciaService.getFranquiciaById(id);
    }

    @PutMapping("/{id}")
    public Franquicia updateFranquicia(@PathVariable String id, @RequestBody Franquicia franquicia) {
        return franquiciaService.updateFranquicia(id, franquicia);
    }

    @DeleteMapping("/{id}")
    public void deleteFranquicia(@PathVariable String id) {
        franquiciaService.deleteFranquicia(id);
    }

    @PostMapping("/{id}/sucursales")
    public Sucursal addSucursalToFranquicia(@PathVariable String id, @RequestBody Sucursal sucursal) {
        return franquiciaService.addSucursalToFranquicia(id, sucursal);
    }

    @PutMapping("/{id}/nombre")
    public Franquicia updateFranquiciaNombre(@PathVariable String id, @RequestParam String nuevoNombre) {
        return franquiciaService.updateFranquiciaNombre(id, nuevoNombre);
    }

    @GetMapping("/{id}/productos-mas-stock")
    public List<Map<String, Object>> getProductosMasStock(@PathVariable String id) {
        return franquiciaService.getProductosMasStockPorSucursal(id);
    }
}
