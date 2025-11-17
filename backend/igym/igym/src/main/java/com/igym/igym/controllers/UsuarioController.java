package com.igym.igym.controllers;

import com.igym.igym.dtos.UsuarioRequestDTO;
import com.igym.igym.dtos.UsuarioResponseDTO;
import com.igym.igym.model.Usuario;
import com.igym.igym.repositories.UsuarioRepository;
import com.igym.igym.services.UsuarioService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {

    private UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @PostMapping
    public ResponseEntity<UsuarioResponseDTO> insert(@Valid @RequestBody UsuarioRequestDTO usuarioRequestDTO){
        Usuario usuario = usuarioService.insert(usuarioRequestDTO);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(new UsuarioResponseDTO((usuario)));
    }

    @GetMapping
    public ResponseEntity<List<UsuarioResponseDTO>> findAll() {
        List<UsuarioResponseDTO> dtoList = usuarioService.findAll()
                .stream()
                .map(UsuarioResponseDTO::new)
                .collect(Collectors.toList());
        return ResponseEntity.ok(dtoList);
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<UsuarioResponseDTO> findById(@PathVariable Long id) {

        Usuario requestDTO = usuarioService.findById(id);
        UsuarioResponseDTO responseDTO = new UsuarioResponseDTO(requestDTO);
        return ResponseEntity.ok(responseDTO);
    }

    @GetMapping("/cpf/{cpf}")
    public ResponseEntity<UsuarioResponseDTO> findByCpf(@PathVariable String cpf){
        Usuario requestDTO = usuarioService.findByCpf(cpf);
        UsuarioResponseDTO responseDTO = new UsuarioResponseDTO(requestDTO);
        return ResponseEntity.ok(responseDTO);
    }

    @PutMapping("/{id}")
    public ResponseEntity<UsuarioResponseDTO> update(@PathVariable Long id, @RequestBody UsuarioRequestDTO usuarioRequestDTO) {
        Usuario usuarioAtualizado = usuarioService.update(id, usuarioRequestDTO);
        return ResponseEntity.ok(new UsuarioResponseDTO(usuarioAtualizado));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        usuarioService.delete(id);
        return ResponseEntity.noContent().build();
    }


}
