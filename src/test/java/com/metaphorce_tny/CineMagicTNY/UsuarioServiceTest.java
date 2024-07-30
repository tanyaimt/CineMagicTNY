package com.metaphorce_tny.CineMagicTNY;

import com.metaphorce_tny.api.CineMagicTNY.model.Usuario;
import com.metaphorce_tny.api.CineMagicTNY.repository.UsuarioRepository;
import com.metaphorce_tny.api.CineMagicTNY.service.UsuarioService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.when;

public class UsuarioServiceTest {

    @InjectMocks
    UsuarioService usuarioService;

    @Mock
    UsuarioRepository usuarioRepository;

    @BeforeEach
    public void setup(){
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testListarUsuarios(){
        List<Usuario> listaEsperada = new ArrayList<>();
        listaEsperada.add(new Usuario(1L,"Nombre1", 35, "anonimo@anom.com", "espectador"));
        listaEsperada.add(new Usuario(2L,"Nombre2", 35, "anonimo@anom.com", "espectador"));

        when(usuarioRepository.findAll()).thenReturn(listaEsperada);
        List<Usuario> listaActual = usuarioService.listarUsuarios();

        Assertions.assertEquals(listaEsperada.get(0).getNombre(), listaActual.get(0).getNombre());
        Assertions.assertEquals(listaEsperada.size(), listaActual.size());
    }

    @Test
    public void buscarUsuario(){
        Usuario usuarioEsperada = new Usuario(1L,"Nombre1", 35, "anonimo@anom.com", "espectador");

        when(usuarioRepository.findById(1L)).thenReturn(Optional.of(usuarioEsperada));

        Usuario usuarioActual = usuarioService.buscarPorId(1L);

        Assertions.assertEquals(usuarioEsperada, usuarioActual);
    }
}
