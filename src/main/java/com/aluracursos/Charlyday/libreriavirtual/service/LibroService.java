package com.aluracursos.Charlyday.libreriavirtual.service;

import com.aluracursos.Charlyday.libreriavirtual.dto.AutorDTO;
import com.aluracursos.Charlyday.libreriavirtual.dto.LibroDTO;
import com.aluracursos.Charlyday.libreriavirtual.model.Autor;
import com.aluracursos.Charlyday.libreriavirtual.model.DatosLibro;
import com.aluracursos.Charlyday.libreriavirtual.model.Libro;
import com.aluracursos.Charlyday.libreriavirtual.repository.LibroRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.stream.Collectors;

@Service
public class LibroService {
    @Autowired
    private LibroRepository repository;
    @Autowired
    private AutorService autorService;

    @Transactional
    public void crearLibroDesdeDatos(DatosLibro datosLibro) {
        Libro libro = new Libro();
        libro.setTitulo(datosLibro.titulo());
        List<Autor> autores = datosLibro.autores().stream()
                .map(autorService::obtenerORegistrarAutor)
                .collect(Collectors.toList());
        libro.setAutores(autores);
        libro.setLenguajes(datosLibro.lenguajes());
        libro.setNumeroDescargas(datosLibro.numeroDescargas());
        System.out.println(libro);
        repository.save(libro);
    }

    public List<LibroDTO> listarLibrosRegistrados() {
        List<LibroDTO> libroDTOList = connvierteDatos(repository.findAll());
        libroDTOList.forEach(System.out::println);
        return libroDTOList;
    }

    private List<LibroDTO> connvierteDatos(List<Libro> libros) {
        return libros.stream()
                .map(l -> new LibroDTO(l.getId(), l.getTitulo(), convierteDatosAutor(l.getAutores()),
                        l.getLenguajes(), l.getNumeroDescargas()))
                .collect(Collectors.toList());
    }

    private List<AutorDTO> convierteDatosAutor(List<Autor> autores) {
        return autores.stream()
                .map(a -> new AutorDTO(a.getNombre()))
                .collect(Collectors.toList());
    }
}
