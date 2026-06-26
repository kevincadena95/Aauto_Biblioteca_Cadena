package com.itsqmet.aauto_biblioteca_cadena.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import java.util.*;


@Entity
@Table(name = "libros")
public class Libro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "El campo titulo no puede estar vacio")
    @Size(min = 2, max = 100, message = ("El titulo no cumple con el rango de caracteres de 2-15"))
    @Column(nullable = false)
    private String titulo;

    @NotBlank(message = "El campo IDBN no puede estar vacio")
    private String isbn;

    @Size(max = 500, message = "La sinopsis no puede superar 500 caracteres")
    private String sinopsis;

    @NotBlank(message = "La fecha de publicacion es obligatoria")
    @Pattern(regexp = "\\d{4}-\\d{2}-\\d{2}", message = "La fecha debe tener el formato yyyy-MM-dd")
    private String fechaPublicacion;

    @NotNull(message = "El precio es obligatorio")
    @Min(value = 0, message = "El precio no puede ser negativo")
    @Column(nullable = false)
    private Double precio;

    @NotNull(message = "El stock es obligatorio")
    @Min(value = 0, message = "El stock no puede ser negativo")
    private Integer stock;

    //relacion con autor
    @ManyToOne
    @JoinColumn(name = "autor_id",  nullable = false)
    @JsonIgnoreProperties("libros")
    private Autor autor;

    //relacion N:N con categoria
    @ManyToMany
    @JoinTable(
            name = "libros_categorias",
            joinColumns = @JoinColumn(name = "libro_id"),
            inverseJoinColumns = @JoinColumn(name = "categoria_id")
    )
    @JsonIgnoreProperties("libros")
    private List<Categoria> categorias = new ArrayList<>();


    public Libro() {
    }

    public Libro(Long id, String titulo, String isbn, String sinopsis, String fechaPublicacion, Double precio, Integer stock, Autor autor, List<Categoria> categorias) {
        this.id = id;
        this.titulo = titulo;
        this.isbn = isbn;
        this.sinopsis = sinopsis;
        this.fechaPublicacion = fechaPublicacion;
        this.precio = precio;
        this.stock = stock;
        this.autor = autor;
        this.categorias = categorias;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getSinopsis() {
        return sinopsis;
    }

    public void setSinopsis(String sinopsis) {
        this.sinopsis = sinopsis;
    }

    public String getFechaPublicacion() {
        return fechaPublicacion;
    }

    public void setFechaPublicacion(String fechaPublicacion) {
        this.fechaPublicacion = fechaPublicacion;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public Autor getAutor() {
        return autor;
    }

    public void setAutor(Autor autor) {
        this.autor = autor;
    }

    public List<Categoria> getCategorias() {
        return categorias;
    }

    public void setCategorias(List<Categoria> categorias) {
        this.categorias = categorias;
    }
}
