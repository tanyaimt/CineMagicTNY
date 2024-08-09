package com.metaphorce_tny.api.CineMagicTNY.services;

import com.metaphorce_tny.api.CineMagicTNY.model.Sala;
import java.util.List;

public interface ISalaService {

    List<Sala> listarSala();
    Sala buscarPorId(Long id_sala);
    Sala crearSala(Sala sala);
    Sala actualizarSala(Long id_sala, Sala sala);
    void eliminarSala(Long id_sala);
}
