package com.igym.igym.services;


import com.igym.igym.dtos.ProfessorRequestDTO;
import com.igym.igym.model.Professor;
import com.igym.igym.model.Usuario;
import com.igym.igym.repositories.ProfessorRepository;
import com.igym.igym.repositories.UsuarioRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.time.LocalDate;
import java.util.List;

@Service
public class ProfessorService {

    private ProfessorRepository professorRepository;
    private UsuarioRepository usuarioRepository;


    public ProfessorService(ProfessorRepository professorRepository, UsuarioRepository usuarioRepository) {
        this.professorRepository = professorRepository;
        this.usuarioRepository = usuarioRepository;
    }

    public List<Professor> findAll(){
        return professorRepository.findAll();
    }

    public Professor findByCref(String cref){
        return professorRepository.findByCref(cref)
                .orElseThrow(() -> new RuntimeException(String.format("Professor não existente com o cref: %s", cref)));
    }

    @Transactional
    public Professor insert(ProfessorRequestDTO professorRequestDTO){
        Usuario usuario = new Usuario();
        preencherCamposProfessor(usuario, professorRequestDTO);

        usuario = usuarioRepository.save(usuario);

        Professor professor = new Professor();

        professor.setUsuario(usuario);
        professor.setCref(professorRequestDTO.getCref());

        return professorRepository.save(professor);

    }

    public void preencherCamposProfessor(Usuario usuario, ProfessorRequestDTO dto){
        usuario.setNome(dto.getNome());
        usuario.setEmail(dto.getEmail());
        usuario.setSenha(dto.getSenha());
        usuario.setCpf(dto.getCpf());
        usuario.setTelefone(dto.getTelefone());
        usuario.setDataNascimento(dto.getDataNascimento());
        usuario.setGenero(dto.getGenero());

        if(dto.getDataNascimento() != null){
            LocalDate dataNascimento = dto.getDataNascimento();
            LocalDate dataAtual = LocalDate.now();
            Integer idade = java.time.Period.between(dataNascimento, dataAtual).getYears();
            usuario.setIdade(idade);
        }

    }
}
