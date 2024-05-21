package com.aluracursos.Charlyday.libreriavirtual.service;

import com.aluracursos.Charlyday.libreriavirtual.dto.*;
import com.aluracursos.Charlyday.libreriavirtual.model.Autor;
import com.aluracursos.Charlyday.libreriavirtual.model.Libro;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class Texto {
    StringBuilder sb = new StringBuilder();
    public String libros(List<LibroDTO> libros) {
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

    public String libroGuardadoExitoso(Libro libro) {
        return """
               ---------- LIBRO GUARDADO CON ÉXITO ----------
               Título: %s
               Autores: %s
               Lenguajes: %s
               Numero de descargas: %d
               ---------------------------------------------------------
               """.formatted(
                libro.getTitulo(),
                libro.getAutores().stream().map(Autor::getNombre).collect(Collectors.joining(", ")),
                String.join(", ", libro.getLenguajes()),
                libro.getNumeroDescargas()
        );
    }

    public String autoresPorFecha(List<AutorPorFechaDTO> autorPorFechaDTO) {
        for (AutorPorFechaDTO autor : autorPorFechaDTO){
            sb.append("---------- AUTOR ----------\n")
                    .append("Nombre: ").append(autor.nombre()).append("\n")
                    .append("Fecha de nacimiento: ").append(autor.nacimiento()).append("\n")
                    .append("Fecha de fallecimiento: ").append(autor.muerte()).append("\n")
                    .append("------------------------\n");
        }
        return  sb.toString();
    }
}
