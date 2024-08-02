package com.metaphorce_tny.api.CineMagicTNY.service;

import com.metaphorce_tny.api.CineMagicTNY.model.Administrador;
import java.util.List;

public interface IAdministradorService {

    List<Administrador> listarAdministrador();
    Administrador buscarPorId(Long id_administrador);
    Administrador buscarPorUserName(Long user_name);
    Administrador crearAdministrador(Administrador administrador);
    Administrador actualizarAdministrador(Long id_administrador, Administrador administrador);
    void eliminarAdministrador(Long id_administrador);
}
