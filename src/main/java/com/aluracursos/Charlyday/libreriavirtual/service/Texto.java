package com.aluracursos.Charlyday.libreriavirtual.service;

import com.aluracursos.Charlyday.libreriavirtual.dto.AutorDTO;
import com.aluracursos.Charlyday.libreriavirtual.dto.AutorYLibrosDTO;
import com.aluracursos.Charlyday.libreriavirtual.dto.LibroDTO;
import com.aluracursos.Charlyday.libreriavirtual.dto.LibroPorAutorDTO;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class Texto {
    public String libros(List<LibroDTO> libros) {
        StringBuilder sb = new StringBuilder();
        for (LibroDTO libro : libros) {
            sb.append("---------- LIBRO ----------\n")
                    .append("Titulo: ").append(libro.titulo()).append("\n")
                    .append("Autor: ").append(libro.autores().stream()
                            .map(AutorDTO::nombre)
                            .collect(Collectors.joining(", "))).append("\n")
                    .append("Idioma: ").append(String.join(", ", libro.lenguajes())).append("\n")
                    .append("Numero de descargas: ").append(libro.numeroDescargas()).append("\n")
                    .append("-----------------------------\n");
        }
        return sb.toString();
    }

    public String librosPorAutor(List<AutorYLibrosDTO> autoresYLibros) {
        StringBuilder sb = new StringBuilder();
        for (AutorYLibrosDTO autorYLibros : autoresYLibros) {
            sb.append("---------- ").append(autorYLibros.nombre().toUpperCase()).append(" ----------\n");
            for (LibroPorAutorDTO libro : autorYLibros.libros()) {
                sb.append("---------- LIBRO ----------\n")
                        .append("Titulo: ").append(libro.titulo()).append("\n")
                        .append("Idioma: ").append(String.join(", ", libro.lenguajes())).append("\n")
                        .append("Numero de descargas: ").append(libro.numeroDescargas()).append("\n")
                        .append("-----------------------------\n");
            }
        }
        return sb.toString();
    }
}
