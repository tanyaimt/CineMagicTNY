package com.metaphorce_tny.api.CineMagicTNY.controller;

import com.metaphorce_tny.api.CineMagicTNY.model.Administrador;
import com.metaphorce_tny.api.CineMagicTNY.service.IAdministradorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api-administradors")
public class AdministradorController {
    @Autowired
    IAdministradorService serviceAdministrador;
    // TODO: Implement REST endpoints for CRUD operations

    @GetMapping("/administrador")
    public List<Administrador> listarAdministradors(){
        return serviceAdministrador.listarAdministrador();
    }

    @GetMapping("/administrador/{id_administrador}")
    public ResponseEntity<Administrador> buscarAdministrador(@PathVariable Long id_administrador){
        Administrador administrador = serviceAdministrador.buscarPorId(id_administrador);
        return ResponseEntity.ok(administrador);
    }

    @PostMapping("/administrador")
    public ResponseEntity<Administrador> crearAdministrador(@RequestBody Administrador administrador){
        Administrador administradorCreada = serviceAdministrador.crearAdministrador(administrador);
        return ResponseEntity.status(HttpStatus.CREATED).body(administradorCreada);
    }

    @PutMapping("/administrador/{id_administrador}")
    public ResponseEntity<Administrador> actualizarAdministrador(@PathVariable Long id_administrador, @RequestBody Administrador administrador){
        Administrador administradorActualizar = serviceAdministrador.buscarPorId(id_administrador);
        if (administradorActualizar == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

        administradorActualizar.setSalario(administrador.getSalario());
        administradorActualizar.setPuesto(administrador.getPuesto());


        /*Administrador administradorActualizada = serviceAdministrador.actualizarAdministrador(id_administrador, administradorActualizar);*/
        serviceAdministrador.actualizarAdministrador(id_administrador, administradorActualizar);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @DeleteMapping("/administrador/{id_administrador}")
    public ResponseEntity<Administrador> eliminarAdministrador(@PathVariable Long id_administrador){
        serviceAdministrador.eliminarAdministrador(id_administrador);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
