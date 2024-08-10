package com.metaphorce_tny.api.CineMagicTNY.controller;

import com.metaphorce_tny.api.CineMagicTNY.exceptions.NotFoundExeption;
import com.metaphorce_tny.api.CineMagicTNY.model.Funcion;
import com.metaphorce_tny.api.CineMagicTNY.services.IFuncionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api-funciones")
@CrossOrigin(origins = "http://localhost:3000") // Replace with your frontend URL
public class FuncionController {
    @Autowired
    IFuncionService serviceFuncion;
    // TODO: Implement REST endpoints for CRUD operations

    @GetMapping("/funcion")
    public List<Funcion> listarFuncions(){
        return serviceFuncion.listarFuncion();
    }

    @GetMapping("/funcion/{id_funcion}")
    public ResponseEntity<Funcion> buscarFuncion(@PathVariable Long id_funcion){
        Funcion funcion = serviceFuncion.buscarPorId(id_funcion);
        if(funcion == null){
           throw new NotFoundExeption("Funcion no encontrada", "err-12", HttpStatus.NOT_FOUND);
        }
        return ResponseEntity.ok(funcion);
    }

    @PostMapping("/funcion")
    public ResponseEntity<Funcion> crearFuncion(@RequestBody Funcion funcion){
        Funcion funcionCreada = serviceFuncion.crearFuncion(funcion);
        return ResponseEntity.status(HttpStatus.CREATED).body(funcionCreada);
    }

    @PutMapping("/funcion/{id_funcion}")
    public ResponseEntity<Funcion> actualizarFuncion(@PathVariable Long id_funcion, @RequestBody Funcion funcion){
        Funcion funcionActualizar = serviceFuncion.buscarPorId(id_funcion);
        if (funcionActualizar == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

        funcionActualizar.setHorario(funcion.getHorario());
        funcionActualizar.setIdSala(funcion.getIdSala());
        funcionActualizar.setIdPelicula(funcion.getIdPelicula());
        funcionActualizar.setUltimoEditor(funcion.getUltimoEditor());


        /*Funcion funcionActualizada = serviceFuncion.actualizarFuncion(id_funcion, funcionActualizar);*/
        serviceFuncion.actualizarFuncion(id_funcion, funcionActualizar);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @DeleteMapping("/funcion/{id_funcion}")
    public ResponseEntity<Funcion> eliminarFuncion(@PathVariable Long id_funcion){
        serviceFuncion.eliminarFuncion(id_funcion);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
