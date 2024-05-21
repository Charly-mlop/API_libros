package com.aluracursos.Charlyday.libreriavirtual.dto;

import com.aluracursos.Charlyday.libreriavirtual.model.Autor;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;

import java.util.List;

public record LibroDTO(
        Long id,
        String titulo,
        List<AutorDTO> autores,
        List<String> lenguajes,
        Integer numeroDescargas
) {
}
