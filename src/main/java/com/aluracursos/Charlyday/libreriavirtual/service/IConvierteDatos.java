package com.aluracursos.Charlyday.libreriavirtual.service;

public interface IConvierteDatos {
    <T> T obtenerDatos(String json, Class<T> clase);
}
