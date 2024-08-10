package com.metaphorce_tny.api.CineMagicTNY.controller;

import com.metaphorce_tny.api.CineMagicTNY.model.Pelicula;
import com.metaphorce_tny.api.CineMagicTNY.services.IPeliculaService;
import com.metaphorce_tny.api.CineMagicTNY.exceptions.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api-peliculas")
@CrossOrigin(origins = "http://localhost:3000") // Replace with your frontend URL
public class PeliculaController {
    @Autowired
    IPeliculaService servicePelicula;
    // TODO: Implement REST endpoints for CRUD operations

    @GetMapping("/pelicula")
    public List<Pelicula> listarPeliculas(){
         return servicePelicula.listarPelicula();
    }

    @GetMapping("/pelicula/{id_pelicula}")
    public ResponseEntity<Pelicula> buscarPelicula(@PathVariable Long id_pelicula){
        Pelicula pelicula = servicePelicula.buscarPorId(id_pelicula);
        if(pelicula == null){
           throw new NotFoundExeption("Pelicula no encontrada", "err-12", HttpStatus.NOT_FOUND);
        }
        return ResponseEntity.ok(pelicula);
    }

    @PostMapping("/pelicula")
    public ResponseEntity<Pelicula> crearPelicula(@RequestBody Pelicula pelicula){
        Pelicula peliculaCreada = servicePelicula.crearPelicula(pelicula);
        return ResponseEntity.status(HttpStatus.CREATED).body(peliculaCreada);
    }

    @PutMapping("/pelicula/{id_pelicula}")
    public ResponseEntity<Pelicula> actualizarPelicula(@PathVariable Long id_pelicula, @RequestBody Pelicula pelicula){
        Pelicula peliculaActualizar = servicePelicula.buscarPorId(id_pelicula);
        if (peliculaActualizar == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

        peliculaActualizar.setNombre(pelicula.getNombre());
        peliculaActualizar.setDuracion(pelicula.getDuracion());
        peliculaActualizar.setClasificacion(pelicula.getClasificacion());
        peliculaActualizar.setDescripcion(pelicula.getDescripcion());
        peliculaActualizar.setFechaEstreno(pelicula.getFechaEstreno());
        peliculaActualizar.setUltimoEditor(pelicula.getUltimoEditor());

        /*Pelicula peliculaActualizada = servicePelicula.actualizarPelicula(id_pelicula, peliculaActualizar);*/
        servicePelicula.actualizarPelicula(id_pelicula, peliculaActualizar);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @DeleteMapping("/pelicula/{id_pelicula}")
    public ResponseEntity<Pelicula> eliminarPelicula(@PathVariable Long id_pelicula){
        servicePelicula.eliminarPelicula(id_pelicula);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
