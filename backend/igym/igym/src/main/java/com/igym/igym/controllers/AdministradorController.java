package com.igym.igym.controllers;

import com.igym.igym.model.Administrador;
import com.igym.igym.services.AdministradorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/administradores")
public class AdministradorController {

    @Autowired
    private AdministradorService administradorService;

    @PostMapping
    public ResponseEntity<Administrador> criarAdministrador(@RequestBody Administrador administrador) {
        Administrador adminSalvo = administradorService.insert(administrador);
        return ResponseEntity.ok(adminSalvo);
    }
}
