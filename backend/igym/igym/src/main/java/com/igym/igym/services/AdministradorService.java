package com.igym.igym.services;

import com.igym.igym.model.Administrador;
import com.igym.igym.model.Role;
import com.igym.igym.model.Usuario;
import com.igym.igym.repositories.AdministradorRepository;
import com.igym.igym.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AdministradorService {

    private AdministradorRepository administradorRepository;

    private PasswordEncoder passwordEncoder;

    private UsuarioRepository usuarioRepository;

    public AdministradorService(AdministradorRepository administradorRepository, PasswordEncoder passwordEncoder, UsuarioRepository usuarioRepository) {
        this.administradorRepository = administradorRepository;
        this.passwordEncoder = passwordEncoder;
        this.usuarioRepository = usuarioRepository;
    }

    public Usuario insertAdmin(String email, String senha) {
        Usuario admin = new Usuario();
        admin.setEmail(email);
        admin.setSenha(passwordEncoder.encode(senha));
        admin.setRole(Role.ROLE_ADMINISTRADOR);
        return usuarioRepository.save(admin);
    }
}
