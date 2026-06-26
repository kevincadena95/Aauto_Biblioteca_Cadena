package com.itsqmet.aauto_biblioteca_cadena.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import java.util.*;

@Entity
@Table(name = "autores")
public class Autor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "El campo nombre no puede estar vacío")
    @Size(min = 2, max = 25, message = "El nombre debe tener entre 2 y 25 caracteres")
    private String nombre;

    @NotBlank(message = "El campo apellido no puede estar vacío")
    @Size(min = 2, max = 25, message = "El apellido debe tener entre 2 y 25 caracteres")
    private String apellido;


    @Size(max = 500, message = "La biografía corta no puede superar 500 caracteres")
    private String biografiaCorta;


    public Autor() {
    }

    public Autor(Long id, String nombre, String apellido, String biografiaCorta) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.biografiaCorta = biografiaCorta;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getBiografiaCorta() {
        return biografiaCorta;
    }

    public void setBiografiaCorta(String biografiaCorta) {
        this.biografiaCorta = biografiaCorta;
    }

}

