package com.metaphorce_tny.api.CineMagicTNY.controller;

import com.metaphorce_tny.api.CineMagicTNY.model.Espectador;
import com.metaphorce_tny.api.CineMagicTNY.service.IEspectadorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api-espectadors")
public class EspectadorController {
    @Autowired
    IEspectadorService serviceEspectador;
    // TODO: Implement REST endpoints for CRUD operations

    @GetMapping("/espectador")
    public List<Espectador> listarEspectadors(){
        return serviceEspectador.listarEspectador();
    }

    @GetMapping("/espectador/{id_espectador}")
    public ResponseEntity<Espectador> buscarEspectador(@PathVariable Long id_espectador){
        Espectador espectador = serviceEspectador.buscarPorId(id_espectador);
        return ResponseEntity.ok(espectador);
    }

    @PostMapping("/espectador")
    public ResponseEntity<Espectador> crearEspectador(@RequestBody Espectador espectador){
        Espectador espectadorCreada = serviceEspectador.crearEspectador(espectador);
        return ResponseEntity.status(HttpStatus.CREATED).body(espectadorCreada);
    }

    @PutMapping("/espectador/{id_espectador}")
    public ResponseEntity<Espectador> actualizarEspectador(@PathVariable Long id_espectador, @RequestBody Espectador espectador){
        Espectador espectadorActualizar = serviceEspectador.buscarPorId(id_espectador);
        if (espectadorActualizar == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

        espectadorActualizar.setPuntos(espectador.getPuntos());

        /*Espectador espectadorActualizada = serviceEspectador.actualizarEspectador(id_espectador, espectadorActualizar);*/
        serviceEspectador.actualizarEspectador(id_espectador, espectadorActualizar);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @DeleteMapping("/espectador/{id_espectador}")
    public ResponseEntity<Espectador> eliminarEspectador(@PathVariable Long id_espectador){
        serviceEspectador.eliminarEspectador(id_espectador);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
