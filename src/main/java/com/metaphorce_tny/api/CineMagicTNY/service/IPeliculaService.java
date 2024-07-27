package com.metaphorce_tny.api.CineMagicTNY.service;

import com.metaphorce_tny.api.CineMagicTNY.model.Pelicula;
import java.util.List;

public interface IPeliculaService {

    List<Pelicula> listarPelicula();
    Pelicula buscarPorId(Long id_pelicula);
    Pelicula crearPelicula(Pelicula pelicula);
    Pelicula actualizarPelicula(Long id_pelicula, Pelicula pelicula);
    void eliminarPelicula(Long id_pelicula);
}
