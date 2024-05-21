package com.aluracursos.Charlyday.libreriavirtual.service;

import com.aluracursos.Charlyday.libreriavirtual.model.Autor;
import com.aluracursos.Charlyday.libreriavirtual.model.DatosAutor;
import com.aluracursos.Charlyday.libreriavirtual.repository.AutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class AutorService {
    @Autowired
    private AutorRepository autorRepository;
    public Autor obtenerORegistrarAutor(DatosAutor datosAutor) {
        return autorRepository.findByNombre(datosAutor.nombre())
                .orElseGet(() -> {
                    Autor autor = new Autor(datosAutor);
                    return autorRepository.save(autor);
                });
    }
}
