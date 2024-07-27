package com.metaphorce_tny.api.CineMagicTNY.controller;

import com.metaphorce_tny.api.CineMagicTNY.model.Sala;
import com.metaphorce_tny.api.CineMagicTNY.service.ISalaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api-salas")
public class SalaController {
    @Autowired
    ISalaService serviceSala;
    // TODO: Implement REST endpoints for CRUD operations

    @GetMapping("/sala")
    public List<Sala> listarSalas(){
        return serviceSala.listarSala();
    }

    @GetMapping("/sala/{id_sala}")
    public ResponseEntity<Sala> buscarSala(@PathVariable Long id_sala){
        Sala sala = serviceSala.buscarPorId(id_sala);
        return ResponseEntity.ok(sala);
    }

    @PostMapping("/sala")
    public ResponseEntity<Sala> crearSala(@RequestBody Sala sala){
        Sala salaCreada = serviceSala.crearSala(sala);
        return ResponseEntity.status(HttpStatus.CREATED).body(salaCreada);
    }

    @PutMapping("/sala/{id_sala}")
    public ResponseEntity<Sala> actualizarSala(@PathVariable Long id_sala, @RequestBody Sala sala){
        Sala salaActualizar = serviceSala.buscarPorId(id_sala);
        if (salaActualizar == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

        salaActualizar.setCantidadAsientos(sala.getCantidadAsientos());
        salaActualizar.setTipo(sala.getTipo());
        salaActualizar.setCosto(sala.getCosto());
        salaActualizar.setUltimoEditor(sala.getUltimoEditor());

        /*Sala salaActualizada = serviceSala.actualizarSala(id_sala, salaActualizar);*/
        serviceSala.actualizarSala(id_sala, salaActualizar);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @DeleteMapping("/sala/{id_sala}")
    public ResponseEntity<Sala> eliminarSala(@PathVariable Long id_sala){
        serviceSala.eliminarSala(id_sala);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
