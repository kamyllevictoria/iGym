package com.igym.igym.controllers;

import com.igym.igym.dtos.LoginRequestDTO;
import com.igym.igym.dtos.LoginResponseDTO;
import com.igym.igym.services.AuthService;
import com.igym.igym.services.RecuperacaoDeSenhaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final RecuperacaoDeSenhaService recuperacaoDeSenhaService;
    private final AuthService authService;


    @PostMapping("/login")
    public ResponseEntity<LoginResponseDTO> login(@RequestBody LoginRequestDTO loginRequestDTO){
        return ResponseEntity.ok(authService.login(loginRequestDTO));
    }

    @PostMapping("/recuperar-senha")
    public ResponseEntity<String> recuperarSenha(@RequestBody Map<String, String> body){
        recuperacaoDeSenhaService.solicitarRecuperacao(body.get("email"));
        return ResponseEntity.ok("Email de recuperacao enviado.");
    }

    @PostMapping("/redefinir-senha")
    public ResponseEntity<String> redefinirSenha(@RequestBody Map<String, String> body){
        recuperacaoDeSenhaService.redefinirSenha(body.get("token"), body.get("novaSenha"));
        return ResponseEntity.ok("Senha redefinida com sucesso.");
    }

}
