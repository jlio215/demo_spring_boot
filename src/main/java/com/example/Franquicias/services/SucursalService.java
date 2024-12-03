package com.example.Franquicias.services;

import com.example.Franquicias.models.Producto;
import com.example.Franquicias.models.Sucursal;
import com.example.Franquicias.repositories.ProductoRepository;
import com.example.Franquicias.repositories.SucursalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SucursalService {

    private final SucursalRepository sucursalRepository;
    private final ProductoRepository productoRepository;

    @Autowired
    public SucursalService(SucursalRepository sucursalRepository, ProductoRepository productoRepository) {
        this.sucursalRepository = sucursalRepository;
        this.productoRepository = productoRepository;
    }

    // Obtener sucursales por franquiciaId
    public List<Sucursal> getSucursalesByFranquiciaId(String franquiciaId) {
        return sucursalRepository.findByFranquiciaId(franquiciaId);
    }

    public Sucursal updateSucursalNombre(String id, String nuevoNombre) {
        Sucursal sucursal = getSucursalById(id);
        sucursal.setNombre(nuevoNombre);
        return sucursalRepository.save(sucursal);
    }
    

    // Obtener sucursal por ID
    public Sucursal getSucursalById(String id) {
        return sucursalRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Sucursal no encontrada"));
    }

    // Agregar un producto a una sucursal existente
    public Producto addProductoToSucursal(String sucursalId, Producto producto) {
        Sucursal sucursal = getSucursalById(sucursalId);

        // Relacionar el producto con la sucursal
        producto.setSucursalId(sucursal.getId());
        Producto savedProducto = productoRepository.save(producto);

        // Actualizar la lista de productos en la sucursal
        sucursal.getProductos().add(savedProducto);
        sucursalRepository.save(sucursal);

        return savedProducto;
    }

    // Actualizar una sucursal
    public Sucursal updateSucursal(String id, Sucursal updatedSucursal) {
        Sucursal sucursal = getSucursalById(id);

        // Actualizar solo los campos necesarios
        sucursal.setNombre(updatedSucursal.getNombre());

        return sucursalRepository.save(sucursal);
    }

    // Eliminar una sucursal
    public void deleteSucursal(String id) {
        sucursalRepository.deleteById(id);
    }
}
