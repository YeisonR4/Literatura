package com.ChallengeLibro.Literatura.Repository;


import com.ChallengeLibro.Literatura.Model.Autores;
import com.ChallengeLibro.Literatura.Model.Libros;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface Repository extends JpaRepository<Libros, Long> {
    Optional<Libros> indByTituloContainsIgnoreCase(String nombreLibro);
    List<Autores> findByFechaMuerteIsNull();
    List<Libros> findByIdioma();

    @Query("SELECT l FROM Libros l JOIN l.libros l WHERE l.titulo ILIKE %:titulo%")
    List<Libros> librosPorTitulo(String titulo);

    @Query("SELECT l FROM Libros l WHERE l.autor.fechaMuerte IS NULL AND l.titulo ILIKE %:titulo%")
    List<Libros> librosPorTituloYAutorVivo( String titulo);

    @Query("SELECT l FROM Libros l WHERE l.idioma ILIKE %:idioma%")
    List<Libros> librosPorIdioma( String idioma);

}
