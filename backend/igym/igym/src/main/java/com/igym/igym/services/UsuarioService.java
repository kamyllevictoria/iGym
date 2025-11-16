package com.igym.igym.services;

import com.igym.igym.dtos.UsuarioRequestDTO;
import com.igym.igym.model.Usuario;
import com.igym.igym.repositories.UsuarioRepository;
import org.springframework.cglib.core.Local;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Period;
import java.util.List;

@Service
public class UsuarioService {

    private UsuarioRepository usuarioRepository;

    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }


    public List<Usuario> findAll(){
        return usuarioRepository.findAll();
    }

    public Usuario findById(Long id){
        return usuarioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado."));
    }

    public Usuario insert(Usuario usuario){
        usuario.setIdade(calcularIdade(usuario.getDataNascimento()));
        return usuarioRepository.save(usuario);
    }

    private Integer calcularIdade(LocalDate localDate){
        return Period.between(localDate, LocalDate.now()).getYears();
    }

    public Usuario update(Long id, UsuarioRequestDTO usuarioRequestDTO) {
        Usuario usuario = findById(id);

        if (usuarioRequestDTO.getEmail() != null) usuario.setEmail(usuarioRequestDTO.getEmail());
        if (usuarioRequestDTO.getSenha() != null && !usuarioRequestDTO.getSenha().isEmpty()) usuario.setSenha(usuarioRequestDTO.getSenha());
        if (usuarioRequestDTO.getTelefone() != null) usuario.setTelefone(usuarioRequestDTO.getTelefone());

        return usuarioRepository.save(usuario);
    }

    public void delete(Long id) {
        Usuario usuario = usuarioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuário com ID " + id + " não encontrado."));
        usuarioRepository.delete(usuario);
    }

}
