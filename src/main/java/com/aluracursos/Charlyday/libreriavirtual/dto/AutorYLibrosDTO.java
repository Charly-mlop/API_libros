package com.aluracursos.Charlyday.libreriavirtual.dto;

import java.util.List;

public record AutorYLibrosDTO(
        Long id,
        String nombre,
        List<LibroPorAutorDTO> libros
) {
}
