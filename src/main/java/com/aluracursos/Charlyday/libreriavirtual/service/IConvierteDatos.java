package com.aluracursos.Charlyday.libreriavirtual.service;

// Se usa esta interface para crear un metodo generico que servira para el mapeo de un archivo json
public interface IConvierteDatos {
    <T> T obtenerDatos(String json, Class<T> clase);
}
