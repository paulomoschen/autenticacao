package br.edu.utfpr.paulo.autenticacao.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.utfpr.paulo.autenticacao.model.LoginRequest;
import br.edu.utfpr.paulo.autenticacao.services.UsuarioService;

@RestController
@RequestMapping("/auth")
public class AuthController {
    @Autowired
    private UsuarioService usuarioService;

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody LoginRequest loginRequest) {
        String token = usuarioService.login(loginRequest.getEmail(), loginRequest.getSenha());
        return ResponseEntity.ok(token);
    }
}
