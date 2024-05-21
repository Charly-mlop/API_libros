package com.aluracursos.Charlyday.libreriavirtual.repository;

import com.aluracursos.Charlyday.libreriavirtual.model.Libro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LibroRepository extends JpaRepository<Libro, Long> {
}
