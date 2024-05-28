package com.ChallengeLibro.Literatura.Model;

import jakarta.persistence.*;

@Entity

public class Autores {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    private String nombre;
    private String fechaMuerte;
    @ManyToOne
    private Libros libros;

    public Autores(){}

    public Autores(String autor, DatosAutores d ){
        this.nombre = autor;
        this.fechaMuerte = d.fechaMuerte();

    }

    @Override
    public String toString() {
        return "Autores{" +
                "Id=" + Id +
                ", nombre='" + nombre + '\'' +
                ", fechaMuerte='" + fechaMuerte + '\'' +
                ", libros=" + libros +
                '}';
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getFechaMuerte() {
        return fechaMuerte;
    }

    public void setFechaMuerte(String fechaMuerte) {
        this.fechaMuerte = fechaMuerte;
    }

    public Libros getLibros() {
        return libros;
    }

    public void setLibros(Libros libros) {
        this.libros = libros;
    }
}
