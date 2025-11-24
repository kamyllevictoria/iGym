package com.igym.igym.controllers;

import com.igym.igym.dtos.AlunoRequestDTO;
import com.igym.igym.dtos.AlunoResponseDTO;
import com.igym.igym.model.Aluno;
import com.igym.igym.services.AlunoService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

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

    @GetMapping
    public ResponseEntity<List<AlunoResponseDTO>> findAll(){
        List<AlunoResponseDTO> dtoList = alunoService.findAll()
                .stream()
                .map(AlunoResponseDTO::new)
                .collect(Collectors.toList());
        return ResponseEntity.ok(dtoList);
    }

    @GetMapping("/matricula/{matricula}")
    public ResponseEntity<AlunoResponseDTO> findByMatricula(@PathVariable Long matricula){
        Aluno requestDTO = alunoService.findByMatricula(matricula);
        AlunoResponseDTO responseDTO = new AlunoResponseDTO(requestDTO);
        return ResponseEntity.ok(responseDTO);
    }

    @GetMapping("/cpf/{cpf}")
    public ResponseEntity<AlunoResponseDTO> findByCpf(@PathVariable String cpf){
        Aluno requestDTO = alunoService.findByCpf(cpf);
        AlunoResponseDTO responseDTO = new AlunoResponseDTO(requestDTO);
        return ResponseEntity.ok(responseDTO);
    }

    @GetMapping("/usuarioId/{usuarioId}")
    public ResponseEntity<AlunoResponseDTO> findById(@PathVariable Long usuarioId){
        Aluno requestDTO = alunoService.findByUsuarioId(usuarioId);
        AlunoResponseDTO responseDTO = new AlunoResponseDTO(requestDTO);
        return ResponseEntity.ok(responseDTO);
    }

    @PutMapping("/matricula/{matricula}")
    public ResponseEntity<AlunoResponseDTO> update(@PathVariable Long matricula, @RequestBody AlunoRequestDTO alunoRequestDTO){
        Aluno alunoAtualizado = alunoService.update(matricula, alunoRequestDTO);
        return  ResponseEntity.ok(new AlunoResponseDTO(alunoAtualizado));
    }

    @DeleteMapping("/cpf/{cpf}")
    public ResponseEntity<Void> deleteByCpf(@PathVariable String cpf){
        alunoService.deleteByCpf(cpf);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/matricula/{matricula}")
    public ResponseEntity<Void> deleteByMatricula(@PathVariable Long matricula){
        alunoService.deleteByMatricula(matricula);
        return ResponseEntity.noContent().build();
    }




}
