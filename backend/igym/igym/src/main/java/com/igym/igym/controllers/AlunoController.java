package com.igym.igym.controllers;

import com.igym.igym.dtos.AlunoRequestDTO;
import com.igym.igym.dtos.AlunoResponseDTO;
import com.igym.igym.model.Aluno;
import com.igym.igym.services.AlunoService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/alunos")
public class AlunoController {

    private AlunoService alunoService;


    public AlunoController(AlunoService alunoService) {
        this.alunoService = alunoService;
    }

    @PostMapping
    public ResponseEntity<AlunoResponseDTO> insert (@Valid @RequestBody AlunoRequestDTO alunoRequestDTO){
        Aluno aluno = alunoService.insert(alunoRequestDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(new AlunoResponseDTO(aluno));
    }

}
