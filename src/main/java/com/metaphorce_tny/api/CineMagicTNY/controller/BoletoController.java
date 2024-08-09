package com.metaphorce_tny.api.CineMagicTNY.controller;

import com.metaphorce_tny.api.CineMagicTNY.model.Boleto;
import com.metaphorce_tny.api.CineMagicTNY.services.IBoletoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api-boletos")
public class BoletoController {
    @Autowired
    IBoletoService serviceBoleto;
    // TODO: Implement REST endpoints for CRUD operations

    @GetMapping("/boleto")
    public List<Boleto> listarBoletos(){
        return serviceBoleto.listarBoleto();
    }

    @GetMapping("/boleto/{id_boleto}")
    public ResponseEntity<Boleto> buscarBoleto(@PathVariable Long id_boleto){
        Boleto boleto = serviceBoleto.buscarPorId(id_boleto);
        return ResponseEntity.ok(boleto);
    }

    @PostMapping("/boleto")
    public ResponseEntity<Boleto> crearBoleto(@RequestBody Boleto boleto){
        Boleto boletoCreada = serviceBoleto.crearBoleto(boleto);
        return ResponseEntity.status(HttpStatus.CREATED).body(boletoCreada);
    }

    @PutMapping("/boleto/{id_boleto}")
    public ResponseEntity<Boleto> actualizarBoleto(@PathVariable Long id_boleto, @RequestBody Boleto boleto){
        Boleto boletoActualizar = serviceBoleto.buscarPorId(id_boleto);
        if (boletoActualizar == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

        boletoActualizar.setIdFuncion(boleto.getIdFuncion());
        boletoActualizar.setIdEspectador(boleto.getIdEspectador());
        boletoActualizar.setFechaCompra(boleto.getFechaCompra());

        /*Boleto boletoActualizada = serviceBoleto.actualizarBoleto(id_boleto, boletoActualizar);*/
        serviceBoleto.actualizarBoleto(id_boleto, boletoActualizar);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @DeleteMapping("/boleto/{id_boleto}")
    public ResponseEntity<Boleto> eliminarBoleto(@PathVariable Long id_boleto){
        serviceBoleto.eliminarBoleto(id_boleto);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
