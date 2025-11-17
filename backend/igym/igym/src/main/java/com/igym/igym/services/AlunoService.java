package com.igym.igym.services;


import com.igym.igym.repositories.AlunoRepository;
import org.springframework.stereotype.Service;


@Service
public class AlunoService {

    private AlunoRepository alunoRepository;

    public AlunoService(AlunoRepository alunoRepository) {
        this.alunoRepository = alunoRepository;
    }
}
