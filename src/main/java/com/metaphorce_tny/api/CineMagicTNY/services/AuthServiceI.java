package com.metaphorce_tny.api.CineMagicTNY.services;


import com.metaphorce_tny.api.CineMagicTNY.model.Auth;
import com.metaphorce_tny.api.CineMagicTNY.model.Usuario;

public interface AuthServiceI{
    Auth login(Usuario usuario);
    Auth registro(Usuario usuario);
}
