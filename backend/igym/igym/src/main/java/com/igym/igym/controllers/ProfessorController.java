package com.igym.igym.controllers;

import com.igym.igym.dtos.ProfessorRequestDTO;
import com.igym.igym.dtos.ProfessorResponseDTO;
import com.igym.igym.model.Aluno;
import com.igym.igym.model.Professor;
import com.igym.igym.services.AlunoService;
import com.igym.igym.services.ProfessorService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping("/alunos/{cref}")
    public ResponseEntity<List<Aluno>> getAlunos(@PathVariable String cref) {
        List<Aluno> alunos = professorService.listAlunos(cref);
        return ResponseEntity.ok(alunos);
    }

    @GetMapping
    public ResponseEntity<List<ProfessorResponseDTO>> getProfessores() {
        List<Professor> professores = professorService.findAll();
        List<ProfessorResponseDTO> dtos = professores.stream()
                .map(ProfessorResponseDTO::new)
                .toList();
        return ResponseEntity.ok(dtos);
    }

    @GetMapping("/{cref}")
    public ResponseEntity<Professor> getProfessor(@PathVariable String cref) {
        Professor professor = professorService.getProfessorByCref(cref);
        return ResponseEntity.ok(professor);
    }

    @PutMapping("/{cref}")
    public ResponseEntity<ProfessorResponseDTO> update(@PathVariable String cref,
                                                       @Valid @RequestBody ProfessorRequestDTO professorRequestDTO) {
        Professor professorAtualizado = professorService.update(cref, professorRequestDTO);
        return ResponseEntity.ok(new ProfessorResponseDTO(professorAtualizado));
    }

    @DeleteMapping("/{cref}")
    public ResponseEntity<Void> delete(@PathVariable String cref) {
        professorService.delete(cref);
        return ResponseEntity.noContent().build();
    }



}
