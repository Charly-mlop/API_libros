package com.aluracursos.Charlyday.libreriavirtual.service;

import com.aluracursos.Charlyday.libreriavirtual.dto.AutorYLibrosDTO;
import com.aluracursos.Charlyday.libreriavirtual.dto.LibroPorAutorDTO;
import com.aluracursos.Charlyday.libreriavirtual.model.Autor;
import com.aluracursos.Charlyday.libreriavirtual.model.DatosAutor;
import com.aluracursos.Charlyday.libreriavirtual.model.Libro;
import com.aluracursos.Charlyday.libreriavirtual.repository.AutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class AutorService {
    @Autowired
    private AutorRepository repository;
    public Autor obtenerORegistrarAutor(DatosAutor datosAutor) {
        return repository.findByNombre(datosAutor.nombre())
                .orElseGet(() -> {
                    Autor autor = new Autor(datosAutor);
                    return repository.save(autor);
                });
    }

    public List<AutorYLibrosDTO> listarPorAutor(String autor) {
        List<Autor> autores = repository.findByNombreContainingIgnoreCase(autor);
        if (autores.isEmpty()){
            System.out.println("Auor no encontrado");
        }
       return  autores.stream()
               .map(a -> new AutorYLibrosDTO(a.getId(), a.getNombre(), convierteDatosLibro(a.getLibros())))
               .collect(Collectors.toList());
    }

    private List<LibroPorAutorDTO> convierteDatosLibro(List<Libro> libros) {
        return libros.stream()
                .map(l -> new LibroPorAutorDTO(l.getTitulo(), l.getLenguajes(), l.getNumeroDescargas()))
                .collect(Collectors.toList());
    }
}
