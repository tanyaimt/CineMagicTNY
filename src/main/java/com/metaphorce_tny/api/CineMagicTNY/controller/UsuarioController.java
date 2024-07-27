package com.metaphorce_tny.api.CineMagicTNY.controller;

import com.metaphorce_tny.api.CineMagicTNY.model.Usuario;
import com.metaphorce_tny.api.CineMagicTNY.service.IUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api-usuarios")
public class UsuarioController {
    @Autowired
    IUsuarioService serviceUsuario;
    // TODO: Implement REST endpoints for CRUD operations

    @GetMapping("/usuario")
    public List<Usuario> listarUsuarios(){
        return serviceUsuario.listarUsuarios();
    }

    @GetMapping("/usuario/{id_usuario}")
    public ResponseEntity<Usuario> buscarUsuario(@PathVariable Long id_usuario){
        Usuario usuario = serviceUsuario.buscarPorId(id_usuario);
        return ResponseEntity.ok(usuario);
    }

    @PostMapping("/usuario")
    public ResponseEntity<Usuario> crearUsuario(@RequestBody Usuario usuario){
        Usuario usuarioCreada = serviceUsuario.crearUsuario(usuario);
        return ResponseEntity.status(HttpStatus.CREATED).body(usuarioCreada);
    }

    @PutMapping("/usuario/{id_usuario}")
    public ResponseEntity<Usuario> actualizarUsuario(@PathVariable Long id_usuario, @RequestBody Usuario usuario){
        Usuario usuarioActualizar = serviceUsuario.buscarPorId(id_usuario);
        if (usuarioActualizar == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

        usuarioActualizar.setNombre(usuario.getNombre());
        usuarioActualizar.setEdad(usuario.getEdad());
        usuarioActualizar.setCorreoElectronico(usuario.getCorreoElectronico());
        usuarioActualizar.setNombre(usuario.getTipo());

        /*Usuario usuarioActualizada = serviceUsuario.actualizarUsuario(id_usuario, usuarioActualizar);*/
        serviceUsuario.actualizarUsuario(id_usuario, usuarioActualizar);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @DeleteMapping("/usuario/{id_usuario}")
    public ResponseEntity<Usuario> eliminarUsuario(@PathVariable Long id_usuario){
        serviceUsuario.eliminarUsuario(id_usuario);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
