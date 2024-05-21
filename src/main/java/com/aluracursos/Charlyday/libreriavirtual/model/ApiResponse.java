package com.aluracursos.Charlyday.libreriavirtual.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;
// Esta clase mapea la lista de resultados ignorando los demas datos recibidos
@JsonIgnoreProperties(ignoreUnknown = true)
public record ApiResponse(
        @JsonAlias("results")List<DatosLibro> resultados
        ) {
}
