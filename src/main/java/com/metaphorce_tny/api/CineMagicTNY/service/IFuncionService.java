package com.metaphorce_tny.api.CineMagicTNY.service;

import com.metaphorce_tny.api.CineMagicTNY.model.Funcion;
import java.util.List;

public interface IFuncionService {

    List<Funcion> listarFuncion();
    Funcion buscarPorId(Long id_funcion);
    Funcion crearFuncion(Funcion funcion);
    Funcion actualizarFuncion(Long id_funcion, Funcion funcion);
    void eliminarFuncion(Long id_funcion);
}
