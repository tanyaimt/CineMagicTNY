package com.metaphorce_tny.api.CineMagicTNY.service;

import com.metaphorce_tny.api.CineMagicTNY.model.Espectador;
import com.metaphorce_tny.api.CineMagicTNY.repository.EspectadorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EspectadorService implements IEspectadorService {
    @Autowired
    private EspectadorRepository espectadorRepository;

    @Override
    public List<Espectador> listarEspectador() {
        return espectadorRepository.findAll();
    }

    @Override
    public Espectador buscarPorId(Long id_espectador) {
        return espectadorRepository.findById(id_espectador).orElse(null);
    }

    @Override
    public Espectador crearEspectador(Espectador espectador) {
        return espectadorRepository.save(espectador);
    }

    @Override
    public Espectador actualizarEspectador(Long id_espectador, Espectador espectador) {
        return espectadorRepository.save(espectador);
    }

    @Override
    public void eliminarEspectador(Long id_espectador) {
        espectadorRepository.deleteById(id_espectador);
    }

    // TODO: Implement methods for CRUD operations
}
