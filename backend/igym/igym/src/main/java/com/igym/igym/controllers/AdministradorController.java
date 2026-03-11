package com.igym.igym.controllers;

import com.igym.igym.dtos.AdminRequestDTO;
import com.igym.igym.model.Usuario;
import com.igym.igym.services.AdministradorService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/administradores")
public class AdministradorController {

    private AdministradorService administradorService;
    private AdminRequestDTO adminRequestDTO;

    public AdministradorController(AdministradorService administradorService, AdminRequestDTO adminRequestDTO) {
        this.administradorService = administradorService;
        this.adminRequestDTO = adminRequestDTO;
    }

    @PreAuthorize("hasAuthority('ROLE_ADMINISTRADOR')")
    @PostMapping
    public ResponseEntity<Usuario> criarAdministrador(@RequestBody AdminRequestDTO dto) {
        Usuario adminSalvo = administradorService.insertAdmin(dto.getEmail(), dto.getSenha());
        return ResponseEntity.ok(adminSalvo);
    }
}
