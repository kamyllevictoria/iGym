package com.igym.igym.services;

import com.igym.igym.model.Administrador;
import com.igym.igym.repositories.AdministradorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AdministradorService {

    @Autowired
    private AdministradorRepository administradorRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;


    public Administrador insert(Administrador administrador) {
        if(administradorRepository.findByEmail(administrador.getEmail()).isPresent()){
            throw new RuntimeException("Email já cadastrado: " + administrador.getEmail());
        }

        administrador.setSenha(passwordEncoder.encode(administrador.getSenha()));

        return administradorRepository.save(administrador);
    }
}
