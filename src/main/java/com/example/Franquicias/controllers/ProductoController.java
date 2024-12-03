package com.example.Franquicias.controllers;

import com.example.Franquicias.models.Producto;
import com.example.Franquicias.services.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/productos")
public class ProductoController {

    private final ProductoService productoService;

    @Autowired
    public ProductoController(ProductoService productoService) {
        this.productoService = productoService;
    }

    @GetMapping("/sucursal/{sucursalId}")
    public List<Producto> getProductosBySucursalId(@PathVariable String sucursalId) {
        return productoService.getProductosBySucursalId(sucursalId);
    }

    @PutMapping("/{id}/stock")
    public Producto updateStock(@PathVariable String id, @RequestParam int stock) {
        return productoService.updateStock(id, stock);
    }

    @PutMapping("/{id}")
    public Producto updateProducto(@PathVariable String id, @RequestBody Producto producto) {
        return productoService.updateProducto(id, producto);
    }

    @DeleteMapping("/{id}")
    public void deleteProducto(@PathVariable String id) {
        productoService.deleteProducto(id);
    }

    @PutMapping("/{id}/nombre")
public Producto updateProductoNombre(@PathVariable String id, @RequestParam String nuevoNombre) {
    return productoService.updateProductoNombre(id, nuevoNombre);
}

}
