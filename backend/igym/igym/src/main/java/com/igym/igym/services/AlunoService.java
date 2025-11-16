package com.igym.igym.services;

import com.igym.igym.dtos.AlunoRequestDTO;
import com.igym.igym.model.Aluno;
import com.igym.igym.model.Usuario;
import com.igym.igym.repositories.AlunoRepository;
import com.igym.igym.repositories.UsuarioRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

@Service
public class AlunoService {

    private AlunoRepository alunoRepository;
    private UsuarioRepository usuarioRepository;
    private AlunoRequestDTO alunoRequestDTO;

    public AlunoService(AlunoRepository alunoRepository, UsuarioRepository usuarioRepository) {
        this.alunoRepository = alunoRepository;
        this.usuarioRepository = usuarioRepository;
    }

}
