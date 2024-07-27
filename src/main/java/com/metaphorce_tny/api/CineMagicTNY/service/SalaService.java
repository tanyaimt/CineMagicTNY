package com.metaphorce_tny.api.CineMagicTNY.service;

import com.metaphorce_tny.api.CineMagicTNY.model.Sala;
import com.metaphorce_tny.api.CineMagicTNY.repository.SalaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SalaService implements ISalaService {
    @Autowired
    private SalaRepository salaRepository;

    @Override
    public List<Sala> listarSala() {
        return salaRepository.findAll();
    }

    @Override
    public Sala buscarPorId(Long id_sala) {
        return salaRepository.findById(id_sala).orElse(null);
    }

    @Override
    public Sala crearSala(Sala sala) {
        return salaRepository.save(sala);
    }

    @Override
    public Sala actualizarSala(Long id_sala, Sala sala) {
        return salaRepository.save(sala);
    }

    @Override
    public void eliminarSala(Long id_sala) {
        salaRepository.deleteById(id_sala);
    }

    // TODO: Implement methods for CRUD operations
}
