package com.igym.igym.controllers;

import com.igym.igym.dtos.FichaDeTreinoRequestDTO;
import com.igym.igym.model.FichaDeTreino;
import com.igym.igym.services.FichaDeTreinoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/fichas")
public class FichaDeTreinoController {

    @Autowired
    private FichaDeTreinoService fichaDeTreinoService;

    @PostMapping
    public ResponseEntity<FichaDeTreino> criarFicha(@RequestBody @Valid FichaDeTreinoRequestDTO dto) {
        FichaDeTreino novaFicha = fichaDeTreinoService.criarFicha(dto);

        return new ResponseEntity<>(novaFicha, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<FichaDeTreino>> findAll() {
        List<FichaDeTreino> fichas = fichaDeTreinoService.findAll();

        return ResponseEntity.ok(fichas);
    }
}
