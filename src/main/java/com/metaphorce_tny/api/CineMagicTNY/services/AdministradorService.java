package com.metaphorce_tny.api.CineMagicTNY.services;

import com.metaphorce_tny.api.CineMagicTNY.model.Administrador;
import com.metaphorce_tny.api.CineMagicTNY.repository.AdministradorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdministradorService implements IAdministradorService {
    @Autowired
    private AdministradorRepository administradorRepository;

    @Override
    public List<Administrador> listarAdministrador() {
        return administradorRepository.findAll();
    }

    @Override
    public Administrador buscarPorId(Long id_administrador) {
        return administradorRepository.findById(id_administrador).orElse(null);
    }

    @Override
    public Administrador crearAdministrador(Administrador administrador) {
        return administradorRepository.save(administrador);
    }

    @Override
    public Administrador actualizarAdministrador(Long id_administrador, Administrador administrador) {
        return administradorRepository.save(administrador);
    }

    @Override
    public void eliminarAdministrador(Long id_administrador) {
        administradorRepository.deleteById(id_administrador);
    }

    // TODO: Implement methods for CRUD operations
}
