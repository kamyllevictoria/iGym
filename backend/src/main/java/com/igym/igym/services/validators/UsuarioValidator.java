package com.igym.igym.services.validators;

import com.igym.igym.exceptions.DuplicateRegisterException;
import com.igym.igym.exceptions.InvalidBirthDateException;
import com.igym.igym.model.Usuario;
import com.igym.igym.repositories.UsuarioRepository;
import com.igym.igym.services.UsuarioService;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.Optional;

@Component
public class UsuarioValidator {

    private UsuarioRepository usuarioRepository;

    public UsuarioValidator(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public void validarCriacao(Usuario usuario){
        verificarDataNascimento(usuario);
        usuarioRepository.findByNomeAndCpf(usuario.getNome(), usuario.getCpf())
                .ifPresent(usuario1 -> {
                    throw new DuplicateRegisterException("Usuario já cadastrado.");
                });

    }
    public void verificarDataNascimento(Usuario usuario){
        if(usuario.getDataNascimento() == null){
            throw new InvalidBirthDateException("A data de nascimento não pode ser nula.");
        }
        if(usuario.getDataNascimento().isAfter(LocalDate.now())){
            throw new InvalidBirthDateException("A data de nascimento deve ser anterior e diferente à data atual.");
        }
        if(usuario.getDataNascimento().isEqual(LocalDate.now())){
            throw new InvalidBirthDateException("A data de nascimento deve ser anterior e diferente à data atual.");
        }
    }


}

