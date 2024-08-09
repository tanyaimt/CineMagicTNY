package com.metaphorce_tny.api.CineMagicTNY.services;

import com.metaphorce_tny.api.CineMagicTNY.model.Pelicula;
import com.metaphorce_tny.api.CineMagicTNY.repository.PeliculaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PeliculaService implements IPeliculaService {
    @Autowired
    private PeliculaRepository peliculaRepository;

    @Override
    public List<Pelicula> listarPelicula() {
        return peliculaRepository.findAll();
    }

    @Override
    public Pelicula buscarPorId(Long id_pelicula) {
        return peliculaRepository.findById(id_pelicula).orElse(null);
    }

    @Override
    public Pelicula crearPelicula(Pelicula pelicula) {
        return peliculaRepository.save(pelicula);
    }

    @Override
    public Pelicula actualizarPelicula(Long id_pelicula, Pelicula pelicula) {
        return peliculaRepository.save(pelicula);
    }

    @Override
    public void eliminarPelicula(Long id_pelicula) {
        peliculaRepository.deleteById(id_pelicula);
    }

    // TODO: Implement methods for CRUD operations
}
