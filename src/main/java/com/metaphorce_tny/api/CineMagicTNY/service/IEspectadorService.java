package com.metaphorce_tny.api.CineMagicTNY.service;

import com.metaphorce_tny.api.CineMagicTNY.model.Espectador;
import java.util.List;

public interface IEspectadorService {

    List<Espectador> listarEspectador();
    Espectador buscarPorId(Long id_espectador);
    Espectador crearEspectador(Espectador espectador);
    Espectador actualizarEspectador(Long id_espectador, Espectador espectador);
    void eliminarEspectador(Long id_espectador);
}
