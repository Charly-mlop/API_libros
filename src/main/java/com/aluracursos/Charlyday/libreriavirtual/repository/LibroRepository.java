package com.aluracursos.Charlyday.libreriavirtual.repository;

import com.aluracursos.Charlyday.libreriavirtual.model.Libro;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LibroRepository extends JpaRepository<Libro, Long> {
}
