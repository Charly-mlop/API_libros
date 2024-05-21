package com.aluracursos.Charlyday.libreriavirtual.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;
//Este metodo mapea los datos necesarios para poder registrar un libro
@JsonIgnoreProperties(ignoreUnknown = true)
public record DatosLibro(
        @JsonAlias("title") String titulo,

        @JsonAlias("authors") List<DatosAutor> autores,

        @JsonAlias("languages") List<String> lenguajes,

        @JsonAlias("download_count") Integer numeroDescargas
) {
}
