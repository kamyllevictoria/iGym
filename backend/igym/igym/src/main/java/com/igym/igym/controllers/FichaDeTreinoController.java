package com.igym.igym.controllers;

import com.igym.igym.dtos.FichaDeTreinoRequestDTO;
import com.igym.igym.dtos.FichaDeTreinoUpdateDTO;
import com.igym.igym.model.FichaDeTreino;
import com.igym.igym.services.FichaDeTreinoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/fichas")
public class FichaDeTreinoController {

    @Autowired
    private FichaDeTreinoService fichaDeTreinoService;

    @PreAuthorize("hasAnyAuthority('ROLE_ADMINISTRADOR', 'ROLE_PROFESSOR')")
    @PostMapping
    public ResponseEntity<FichaDeTreino> criarFicha(@RequestBody @Valid FichaDeTreinoRequestDTO dto) {
        FichaDeTreino novaFicha = fichaDeTreinoService.criarFicha(dto);
        return new ResponseEntity<>(novaFicha, HttpStatus.CREATED);
    }

    @PreAuthorize("hasAuthority('ROLE_ADMINISTRADOR')")
    @GetMapping
    public ResponseEntity<List<FichaDeTreino>> findAll() {
        List<FichaDeTreino> fichas = fichaDeTreinoService.findAll();
        return ResponseEntity.ok(fichas);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_ADMINISTRADOR', 'ROLE_PROFESSOR', 'ROLE_ALUNO')")
    @GetMapping("/{id}")
    public ResponseEntity<FichaDeTreino> findById(@PathVariable Long id) {
        FichaDeTreino ficha = fichaDeTreinoService.findById(id);
        return ResponseEntity.ok(ficha);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_ADMINISTRADOR', 'ROLE_PROFESSOR')")
    @PutMapping("/{id}")
    public ResponseEntity<FichaDeTreino> update(@PathVariable Long id,
                                                @RequestBody @Valid FichaDeTreinoUpdateDTO dto, Authentication authentication) {
        FichaDeTreino fichaAtualizada = fichaDeTreinoService.update(id, dto, authentication);
        return ResponseEntity.ok(fichaAtualizada);
    }

    @PreAuthorize("hasAuthority('ROLE_ADMINISTRADOR')")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        fichaDeTreinoService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PreAuthorize("hasAnyAuthority('ROLE_ADMINISTRADOR', 'ROLE_PROFESSOR', 'ROLE_ALUNO')")
    @GetMapping("/aluno/{alunoId}")
    public ResponseEntity<List<FichaDeTreino>> findByAluno(@PathVariable Long alunoId) {
        List<FichaDeTreino> fichas = fichaDeTreinoService.findByAlunoMatricula(alunoId);
        return ResponseEntity.ok(fichas);
    }

}
