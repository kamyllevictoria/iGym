package com.igym.igym.config;

import com.igym.igym.model.Genero;
import com.igym.igym.model.Role;
import com.igym.igym.model.Usuario;
import com.igym.igym.repositories.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
@RequiredArgsConstructor
public class DataInitializer implements CommandLineRunner {
    private final UsuarioRepository usuarioRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public void run(String... args) throws Exception {
        if(usuarioRepository.findByEmail("admin@igym.com").isEmpty()){
            Usuario admin = new Usuario();
            admin.setEmail("admin@igym.com");
            admin.setSenha(passwordEncoder.encode("adminigym2025#"));
            admin.setNome("Administrador");
            admin.setRole(Role.ROLE_ADMINISTRADOR);

            usuarioRepository.save(admin);
            System.out.println("Admin criado com sucesso!");
        }
    }
}
