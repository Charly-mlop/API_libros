package com.aluracursos.Charlyday.libreriavirtual.dto;

import com.aluracursos.Charlyday.libreriavirtual.model.Libro;

import java.util.List;

public record AutorYLibrosDTO(
        Long id,
        String nombre,
        List<LibroPorAutorDTO> libros
) {
}
