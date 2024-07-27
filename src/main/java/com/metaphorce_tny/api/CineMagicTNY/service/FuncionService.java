package com.metaphorce_tny.api.CineMagicTNY.service;

import com.metaphorce_tny.api.CineMagicTNY.model.Funcion;
import com.metaphorce_tny.api.CineMagicTNY.repository.FuncionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FuncionService implements IFuncionService {
    @Autowired
    private FuncionRepository funcionRepository;

    @Override
    public List<Funcion> listarFuncion() {
        return funcionRepository.findAll();
    }

    @Override
    public Funcion buscarPorId(Long id_funcion) {
        return funcionRepository.findById(id_funcion).orElse(null);
    }

    @Override
    public Funcion crearFuncion(Funcion funcion) {
        return funcionRepository.save(funcion);
    }

    @Override
    public Funcion actualizarFuncion(Long id_funcion, Funcion funcion) {
        return funcionRepository.save(funcion);
    }

    @Override
    public void eliminarFuncion(Long id_funcion) {
        funcionRepository.deleteById(id_funcion);
    }

    // TODO: Implement methods for CRUD operations
}
