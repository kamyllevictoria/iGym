package com.igym.igym.controllers;

import com.igym.igym.dtos.UsuarioRequestDTO;
import com.igym.igym.dtos.UsuarioResponseDTO;
import com.igym.igym.model.Usuario;
import com.igym.igym.repositories.UsuarioRepository;
import com.igym.igym.services.UsuarioService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {

    private UsuarioRepository usuarioRepository;
    private UsuarioService usuarioService;

    public UsuarioController(UsuarioRepository usuarioRepository, UsuarioService usuarioService) {
        this.usuarioRepository = usuarioRepository;
        this.usuarioService = usuarioService;
    }

    @PostMapping
    public ResponseEntity<UsuarioResponseDTO> insert(@RequestBody UsuarioRequestDTO usuarioRequestDTO){
        Usuario usuario = new Usuario();
        usuario.setNome(usuarioRequestDTO.getNome());
        usuario.setEmail(usuarioRequestDTO.getEmail());
        usuario.setSenha(usuarioRequestDTO.getSenha());
        usuario.setTelefone(usuarioRequestDTO.getTelefone());
        usuario.setGenero(usuarioRequestDTO.getGenero());
        usuario.setDataNascimento(usuarioRequestDTO.getDataNascimento());
        Usuario usuarioSalvo = usuarioService.insert(usuario);
        UsuarioResponseDTO usuarioResponseDTO = new UsuarioResponseDTO(usuarioSalvo);
        return ResponseEntity.status(HttpStatus.CREATED).body(usuarioResponseDTO);
    }


    @GetMapping
    public ResponseEntity<List<UsuarioResponseDTO>> findAll() {
        List<UsuarioResponseDTO> dtoList = usuarioService.findAll()
                .stream()
                .map(UsuarioResponseDTO::new)
                .collect(Collectors.toList());
        return ResponseEntity.ok(dtoList);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UsuarioResponseDTO> findById(@PathVariable Long id) {

        Usuario requestDTO = usuarioService.findById(id);
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
