package com.igym.igym.controllers;

import com.igym.igym.dtos.ProfessorRequestDTO;
import com.igym.igym.dtos.ProfessorResponseDTO;
import com.igym.igym.model.Professor;
import com.igym.igym.services.AlunoService;
import com.igym.igym.services.ProfessorService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/professores")
public class ProfessorController {

    private ProfessorService professorService;
    private AlunoService alunoService;

    public ProfessorController(ProfessorService professorService, AlunoService alunoService) {
        this.professorService = professorService;
        this.alunoService = alunoService;
    }

    @PostMapping
    public ResponseEntity<ProfessorResponseDTO> insert(@Valid @RequestBody ProfessorRequestDTO professorRequestDTO){
        Professor professor = professorService.insert(professorRequestDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(new ProfessorResponseDTO((professor)));
    }
}
