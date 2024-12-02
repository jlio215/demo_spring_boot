package com.example.Franquicias.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.util.List;

@Document(collection = "sucursales")
public class Sucursal {

    @Id
    private String id;

    private String nombre;

    private String franquiciaId; // Referencia a la franquicia a la que pertenece

    private List<Producto> productos;

    // Getters y Setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getFranquiciaId() {
        return franquiciaId;
    }

    public void setFranquiciaId(String franquiciaId) {
        this.franquiciaId = franquiciaId;
    }

    public List<Producto> getProductos() {
        return productos;
    }

    public void setProductos(List<Producto> productos) {
        this.productos = productos;
    }
}
