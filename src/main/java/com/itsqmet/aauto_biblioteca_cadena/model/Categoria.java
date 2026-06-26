package com.itsqmet.aauto_biblioteca_cadena.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import java.util.*;

@Entity
@Table(name = "categorias")
public class Categoria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "El campo nombre de categoría no puede estar vacío")
    @Size(min = 2, max = 50, message = "El nombre de la categoría debe tener entre 2 y 50 caracteres")
    @Column(nullable = false, unique = true)
    private String nombreCategoria;

    @Size(max = 200, message = "La descripción no puede superar 200 caracteres")
    private String descripcion;


    public Categoria() {
    }

    public Categoria(Long id, String nombreCategoria, String descripcion) {
        this.id = id;
        this.nombreCategoria = nombreCategoria;
        this.descripcion = descripcion;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombreCategoria() {
        return nombreCategoria;
    }

    public void setNombreCategoria(String nombreCategoria) {
        this.nombreCategoria = nombreCategoria;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
