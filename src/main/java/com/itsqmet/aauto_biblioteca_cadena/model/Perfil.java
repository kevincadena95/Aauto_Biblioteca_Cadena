package com.itsqmet.aauto_biblioteca_cadena.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;

@Entity
@Table(name = "perfiles")
public class Perfil {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "El campo fecha de nacimiento no puede estar vacío")
    @Pattern(regexp = "\\d{4}-\\d{2}-\\d{2}", message = "La fecha de nacimiento debe tener el formato yyyy-MM-dd")
    private String fechaNacimiento;

    @Pattern(regexp = "\\d{4}-\\d{2}-\\d{2}", message = "La fecha de fallecimiento debe tener el formato yyyy-MM-dd")
    private String fechaFallecimiento;

    @NotBlank(message = "El campo nacionalidad no puede estar vacío")
    @Size(min = 2, max = 50, message = "La nacionalidad debe tener entre 2 y 50 caracteres")
    @Column(nullable = false)
    private String nacionalidad;

    @NotBlank(message = "El campo ocupacion no puede estar vacío")
    @Size(max = 50, message = "La ocupacion no puede superar 50 caracteres")
    private String ocupacion;

    @Size(max = 500, message = "La reconocimientos/premios no puede superar 500 caracteres")
    private String reconocimientos;

    public Perfil() {
    }

    public Perfil(Long id, String fechaNacimiento, String fechaFallecimiento, String nacionalidad, String ocupacion, String reconocimientos) {
        this.id = id;
        this.fechaNacimiento = fechaNacimiento;
        this.fechaFallecimiento = fechaFallecimiento;
        this.nacionalidad = nacionalidad;
        this.ocupacion = ocupacion;
        this.reconocimientos = reconocimientos;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getFechaFallecimiento() {
        return fechaFallecimiento;
    }

    public void setFechaFallecimiento(String fechaFallecimiento) {
        this.fechaFallecimiento = fechaFallecimiento;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    public String getOcupacion() {
        return ocupacion;
    }

    public void setOcupacion(String ocupacion) {
        this.ocupacion = ocupacion;
    }

    public String getReconocimientos() {
        return reconocimientos;
    }

    public void setReconocimientos(String reconocimientos) {
        this.reconocimientos = reconocimientos;
    }
}
