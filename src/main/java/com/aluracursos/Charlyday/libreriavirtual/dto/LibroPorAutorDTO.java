package com.aluracursos.Charlyday.libreriavirtual.dto;

import java.util.List;

public record LibroPorAutorDTO(
        String titulo,
        List<String> lenguajes,
        Integer numeroDescargas
) {
}
