package com.aluracursos.Charlyday.libreriavirtual.principal;

import com.aluracursos.Charlyday.libreriavirtual.dto.AutorPorFechaDTO;
import com.aluracursos.Charlyday.libreriavirtual.dto.AutorYLibrosDTO;
import com.aluracursos.Charlyday.libreriavirtual.dto.LibroDTO;
import com.aluracursos.Charlyday.libreriavirtual.model.*;
import com.aluracursos.Charlyday.libreriavirtual.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Scanner;

@Component
public class Principal {
    private String autor;
    private final Scanner src = new Scanner(System.in);
    private final ConsumoAPI consumoAPI = new ConsumoAPI();
    private final String URL_BASE = "https://gutendex.com/books/?search=";
    private final ConvierteDatos convierteDatos = new ConvierteDatos();
    @Autowired
    private Texto texto;
    @Autowired
    private LibroService libroService;
    @Autowired
    private AutorService autorService;

    public void muestraElMenu() {
        var opcion = -1;
        while (opcion != 0){
            var menu = """
                    1 - Buscar libro por titulo
                    2 - Listar libros registrados
                    3 - Listar libros por autores registrados
                    4 - Listar autores vivos en un determinado año
                    5 - Listar libros por idioma
                    
                    0 - Salir
                    """;
            System.out.println(menu);
            opcion = src.nextInt();
            src.nextLine();

            switch (opcion) {
                case 1:
                    buscarLibroWeb();
                    break;
                case 2:
                    System.out.println(texto.libros(listarLibrosRegistrados()));;
                    break;
                case 3:
                    System.out.println(texto.librosPorAutor(listarPorAutor()));
                    break;
                case 4:
                    System.out.println(texto.autoresPorFecha(autoresPorFecha()));
            }
        }
    }

    private List<AutorPorFechaDTO> autoresPorFecha() {
        System.out.println("Escribe el año en que quieres buscar");
        Integer fecha = src.nextInt();
        return autorService.listarAutorPorFecha(fecha);
    }

    private List<AutorYLibrosDTO> listarPorAutor() {
        System.out.println("Escribe el nombre del autor que deseas buscar");
        autor = src.nextLine();
        return autorService.listarPorAutor(autor);
    }

    private void buscarLibroWeb() {
        ApiResponse apiResponse = getDatosLibro();
        if (apiResponse.resultados() != null && !apiResponse.resultados().isEmpty()){
            DatosLibro datosLibro = apiResponse.resultados().get(0);
            System.out.println(datosLibro);
            libroService.crearLibroDesdeDatos(datosLibro);
        }else {
            System.out.println("No se encontraron resultados\n");
        }

    }

    private ApiResponse getDatosLibro() {
        System.out.println("Escribe el nombre del libro que quieres buscar");
        var nombreLibro = src.nextLine();
        var json = consumoAPI.obtenerDatos(URL_BASE + nombreLibro.replace(" ", "+").replace("and", "%20"));
        ApiResponse datos = convierteDatos.obtenerDatos(json, ApiResponse.class);
        return datos;
    }

    private List<LibroDTO> listarLibrosRegistrados() {
        return libroService.listarLibrosRegistrados();
    }
}