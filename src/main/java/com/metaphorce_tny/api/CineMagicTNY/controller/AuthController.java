package com.metaphorce_tny.api.CineMagicTNY.controller;

import com.metaphorce_tny.api.CineMagicTNY.model.Auth;
import com.metaphorce_tny.api.CineMagicTNY.model.Usuario;
import com.metaphorce_tny.api.CineMagicTNY.services.AuthServiceI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {
    @Autowired
    AuthServiceI authService;

    @PostMapping("/login")
    public ResponseEntity<Auth> login(@RequestBody Usuario usuario){
        Auth auth = authService.login(usuario);
        return ResponseEntity.ok(auth);
    }

    @PostMapping("/registro")
    public ResponseEntity<Auth> registro(@RequestBody Usuario usuario){
        Auth auth = authService.registro(usuario);
        return ResponseEntity.ok(auth);
    }
}