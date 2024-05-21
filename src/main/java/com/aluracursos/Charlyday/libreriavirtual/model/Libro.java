package com.aluracursos.Charlyday.libreriavirtual.model;

import java.util.List;

public class Libro {
    private Long id;
    private String titulo;
    private List<Autor> autores;
    private List<String> leguajes;
    private Integer numeroDescargas;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public List<Autor> getAutores() {
        return autores;
    }

    public void setAutores(List<Autor> autores) {
        this.autores = autores;
    }

    public List<String> getLeguajes() {
        return leguajes;
    }

    public void setLeguajes(List<String> leguajes) {
        this.leguajes = leguajes;
    }

    public Integer getNumeroDescargas() {
        return numeroDescargas;
    }

    public void setNumeroDescargas(Integer numeroDescargas) {
        this.numeroDescargas = numeroDescargas;
    }
}
