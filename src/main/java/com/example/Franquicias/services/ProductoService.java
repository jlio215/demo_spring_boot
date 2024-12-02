package com.example.Franquicias.services;

import com.example.Franquicias.models.Producto;
import com.example.Franquicias.repositories.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductoService {

    private final ProductoRepository productoRepository;

    @Autowired
    public ProductoService(ProductoRepository productoRepository) {
        this.productoRepository = productoRepository;
    }

    // Obtener productos por sucursalId
    public List<Producto> getProductosBySucursalId(String sucursalId) {
        return productoRepository.findBySucursalId(sucursalId);
    }

    // Modificar el stock de un producto
    public Producto updateStock(String id, int stock) {
        Producto producto = productoRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Producto no encontrado"));
        producto.setStock(stock);
        return productoRepository.save(producto);
    }

    // Actualizar un producto
    public Producto updateProducto(String id, Producto updatedProducto) {
        Producto producto = productoRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Producto no encontrado"));
        producto.setNombre(updatedProducto.getNombre());
        return productoRepository.save(producto);
    }

    // Eliminar un producto
    public void deleteProducto(String id) {
        productoRepository.deleteById(id);
    }
}
