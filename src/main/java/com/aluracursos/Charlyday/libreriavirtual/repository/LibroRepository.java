package com.aluracursos.Charlyday.libreriavirtual.repository;

import com.aluracursos.Charlyday.libreriavirtual.model.Libro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface LibroRepository extends JpaRepository<Libro, Long> {
    Optional<Object> findByTituloEquals(String titulo);

    @Query("SELECT l FROM Libro l WHERE %:idioma% MEMBER OF l.lenguajes")
    List<Libro> findLibrosPorIdioma(String idioma);
}