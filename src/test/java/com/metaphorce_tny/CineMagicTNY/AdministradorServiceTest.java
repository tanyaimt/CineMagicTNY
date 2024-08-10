package com.metaphorce_tny.CineMagicTNY;

import com.metaphorce_tny.api.CineMagicTNY.model.Administrador;
import com.metaphorce_tny.api.CineMagicTNY.repository.AdministradorRepository;
import com.metaphorce_tny.api.CineMagicTNY.services.AdministradorService;
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

public class AdministradorServiceTest {

    @InjectMocks
    AdministradorService administradorService;

    @Mock
    AdministradorRepository administradorRepository;

    @BeforeEach
    public void setup(){
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testListarAdministradors(){
        List<Administrador> listaEsperada = new ArrayList<>();
        listaEsperada.add(new Administrador(1L, "gerente", 15000.36));
        listaEsperada.add(new Administrador(2L, "cajero", 20000.36));

        when(administradorRepository.findAll()).thenReturn(listaEsperada);
        List<Administrador> listaActual = administradorService.listarAdministrador();

        Assertions.assertEquals(listaEsperada.get(0).getNombre(), listaActual.get(0).getNombre());
        Assertions.assertEquals(listaEsperada.size(), listaActual.size());
    }

    @Test
    public void buscarAdministrador(){
        Administrador administradorEsperada = new Administrador(1L, "gerente", 15000.36);

        when(administradorRepository.findById(1L)).thenReturn(Optional.of(administradorEsperada));

        Administrador administradorActual = administradorService.buscarPorId(1L);

        Assertions.assertEquals(administradorEsperada, administradorEsperada);
    }
}