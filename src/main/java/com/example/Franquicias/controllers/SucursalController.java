package com.example.Franquicias.controllers;

import com.example.Franquicias.models.Sucursal;
import com.example.Franquicias.models.Producto;
import com.example.Franquicias.services.SucursalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/sucursales")
public class SucursalController {

    private final SucursalService sucursalService;

    @Autowired
    public SucursalController(SucursalService sucursalService) {
        this.sucursalService = sucursalService;
    }

    @GetMapping("/franquicia/{franquiciaId}")
    public List<Sucursal> getSucursalesByFranquiciaId(@PathVariable String franquiciaId) {
        return sucursalService.getSucursalesByFranquiciaId(franquiciaId);
    }

    @PostMapping("/{id}/productos")
    public Producto addProductoToSucursal(@PathVariable String id, @RequestBody Producto producto) {
        return sucursalService.addProductoToSucursal(id, producto);
    }

    @PutMapping("/{id}")
    public Sucursal updateSucursal(@PathVariable String id, @RequestBody Sucursal sucursal) {
        return sucursalService.updateSucursal(id, sucursal);
    }

    @DeleteMapping("/{id}")
    public void deleteSucursal(@PathVariable String id) {
        sucursalService.deleteSucursal(id);
    }
}
