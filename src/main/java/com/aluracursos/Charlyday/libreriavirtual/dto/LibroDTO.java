package com.aluracursos.Charlyday.libreriavirtual.dto;

import java.util.List;

public record LibroDTO(
        Long id,
        String titulo,
        List<AutorDTO> autores,
        List<String> lenguajes,
        Integer numeroDescargas
) {
}
