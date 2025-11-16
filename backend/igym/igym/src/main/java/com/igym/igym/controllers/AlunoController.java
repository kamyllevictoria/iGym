package com.igym.igym.controllers;

import com.igym.igym.dtos.AlunoRequestDTO;
import com.igym.igym.repositories.AlunoRepository;
import com.igym.igym.services.AlunoService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/alunos")
public class AlunoController {

    private AlunoRepository alunoRepository;
    private AlunoService alunoService;


    public AlunoController(AlunoRepository alunoRepository, AlunoService alunoService) {
        this.alunoRepository = alunoRepository;
        this.alunoService = alunoService;
    }
}
