package com.metaphorce_tny.api.CineMagicTNY.service;

import com.metaphorce_tny.api.CineMagicTNY.model.Usuario;
import java.util.List;

public interface IUsuarioService {

    List<Usuario> listarUsuarios();
    Usuario buscarPorId(Long id);
    Usuario crearUsuario(Usuario usuario);
    Usuario actualizarUsuario(Long id, Usuario usuario);
    void eliminarUsuario(Long id);
}
