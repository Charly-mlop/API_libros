package com.aluracursos.Charlyday.libreriavirtual.service;

import com.aluracursos.Charlyday.libreriavirtual.model.Autor;
import com.aluracursos.Charlyday.libreriavirtual.model.DatosAutor;
import com.aluracursos.Charlyday.libreriavirtual.repository.AutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


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
}
