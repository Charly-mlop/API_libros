package com.aluracursos.Charlyday.libreriavirtual.principal;

import com.aluracursos.Charlyday.libreriavirtual.model.ApiResponse;
import com.aluracursos.Charlyday.libreriavirtual.model.DatosLibro;
import com.aluracursos.Charlyday.libreriavirtual.service.ConsumoAPI;
import com.aluracursos.Charlyday.libreriavirtual.service.ConvierteDatos;

import java.util.Scanner;

public class Principal {
    private final Scanner src = new Scanner(System.in);
    private final ConsumoAPI consumoAPI = new ConsumoAPI();
    private final String URL_BASE = "https://gutendex.com/books/?search=";
    private final ConvierteDatos convierteDatos = new ConvierteDatos();

    public void muestraElMenu() {
        var opcion = -1;
        while (opcion != 0){
            var menu = """
                    1 - Buscar libro por titulo
                    2 - Listar libros registrados
                    3 - Listar autores registrados
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
            }
        }
    }

    private void buscarLibroWeb() {
        ApiResponse apiResponse = getDatosLibro();
        if (apiResponse.resultados() != null && !apiResponse.resultados().isEmpty()){
            DatosLibro datosLibro = apiResponse.resultados().get(0);
            System.out.println(datosLibro);
        }else {
            System.out.println("No se encontraron resultados\n");
        }

    }

    private ApiResponse getDatosLibro() {
        System.out.println("Escribe el nombre del libro que quieres buscar");
        var nombreLibro = src.nextLine();
        var json = consumoAPI.obtenerDatos(URL_BASE + nombreLibro.replace(" ", "").replace("and", "%20"));
        ApiResponse datos = convierteDatos.obtenerDatos(json, ApiResponse.class);
        return datos;
    }
}