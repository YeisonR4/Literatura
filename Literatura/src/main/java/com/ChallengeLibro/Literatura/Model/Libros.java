package com.ChallengeLibro.Literatura.Model;

import jakarta.persistence.*;

import java.util.List;
@Entity

public class Libros {
    @jakarta.persistence.Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    @Column(unique = true)
    private String titulo;
    private Integer cantidad;
    private String idioma;
    private List<Autores> autores;

    public Libros (){}

    public Libros(DatosLibros datosLibros){
        this.titulo = datosLibros.titulo();
        this.cantidad = datosLibros.cantidad();
        this.idioma = datosLibros.idioma();
    }

    @Override
    public String toString() {
        return "Libros{" +
                "Id=" + Id +
                ", titulo='" + titulo + '\'' +
                ", cantidad=" + cantidad +
                ", idioma='" + idioma + '\'' +
                ", autores=" + autores +
                '}';
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public String getIdioma() {
        return idioma;
    }

    public void setIdioma(String idioma) {
        this.idioma = idioma;
    }

    public List<Autores> getAutores() {
        return autores;
    }

    public void setAutores(List<Autores> autores) {
        this.autores = autores;
    }
}
