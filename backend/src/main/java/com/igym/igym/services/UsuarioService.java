package com.igym.igym.services;

import com.igym.igym.dtos.UsuarioRequestDTO;
import com.igym.igym.model.Usuario;
import com.igym.igym.repositories.UsuarioRepository;
import com.igym.igym.services.validators.UsuarioValidator;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Period;
import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {

    private PasswordEncoder passwordEncoder;
    private UsuarioRepository usuarioRepository;
    private UsuarioValidator usuarioValidator;


    public UsuarioService(PasswordEncoder passwordEncoder, UsuarioRepository usuarioRepository, UsuarioValidator usuarioValidator) {
        this.passwordEncoder = passwordEncoder;
        this.usuarioRepository = usuarioRepository;
        this.usuarioValidator = usuarioValidator;
    }

    public List<Usuario> findAll(){
        return usuarioRepository.findAll();
    }

    public Usuario findById(Long id){
        return usuarioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException(String.format("Usuário não encontrado com o id %s.", id)));
    }

    public Usuario findByCpf(String cpf){
        return usuarioRepository.findByCpf(cpf)
                .orElseThrow(() -> new RuntimeException(String.format("Usuário não encontrado com o cpf %s", cpf)));
    }


    public Usuario insert(UsuarioRequestDTO usuarioRequestDTO){
        Usuario usuario = new Usuario();

        preencherCampos(usuario, usuarioRequestDTO);

        if(usuario.getDataNascimento() != null){
            usuario.setIdade(calcularIdade(usuario.getDataNascimento()));
        }

        usuarioValidator.validarCriacao(usuario);
        usuario.setSenha(passwordEncoder.encode(usuarioRequestDTO.getSenha()));

        return usuarioRepository.save(usuario);
    }

    public int calcularIdade(LocalDate dataNascimento){
        return Period.between(dataNascimento, LocalDate.now()).getYears();
    }

    public Usuario update(Long id, UsuarioRequestDTO usuarioRequestDTO) {
        Usuario usuario = findById(id);

        preencherCampos(usuario, usuarioRequestDTO);

        if (usuarioRequestDTO.getSenha() != null) {
            usuario.setSenha(passwordEncoder.encode(usuarioRequestDTO.getSenha()));
        }

        if (usuario.getDataNascimento() != null) {
            usuario.setIdade(calcularIdade(usuario.getDataNascimento()));
        }

        usuarioValidator.verificarDataNascimento(usuario);
        return usuarioRepository.save(usuario);
    }

    public void delete(Long id) {
        usuarioRepository.delete(findById(id));
    }

    public void preencherCampos(Usuario usuario, UsuarioRequestDTO dto){
        if (dto.getNome() != null) {
            usuario.setNome(dto.getNome());
        }
        if (dto.getEmail() != null) {
            usuario.setEmail(dto.getEmail());
        }
        if (dto.getTelefone() != null) {
            usuario.setTelefone(dto.getTelefone());
        }
        if (dto.getGenero() != null) {
            usuario.setGenero(dto.getGenero());
        }
        if (dto.getCpf() != null) {
            usuario.setCpf(dto.getCpf());
        }
        if (dto.getDataNascimento() != null) {
            usuario.setDataNascimento(dto.getDataNascimento());
        }
    }

}
