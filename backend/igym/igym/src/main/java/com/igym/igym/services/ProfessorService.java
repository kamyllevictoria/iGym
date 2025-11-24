package com.igym.igym.services;


import com.igym.igym.dtos.ProfessorRequestDTO;
import com.igym.igym.model.Aluno;
import com.igym.igym.model.Professor;
import com.igym.igym.model.Usuario;
import com.igym.igym.repositories.AlunoRepository;
import com.igym.igym.repositories.ProfessorRepository;
import com.igym.igym.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.time.LocalDate;
import java.time.Period;
import java.util.List;

@Service
public class ProfessorService {

    private ProfessorRepository professorRepository;
    private UsuarioRepository usuarioRepository;
    private AlunoRepository alunoRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public ProfessorService(ProfessorRepository professorRepository, UsuarioRepository usuarioRepository, AlunoRepository alunoRepository) {
        this.professorRepository = professorRepository;
        this.usuarioRepository = usuarioRepository;
        this.alunoRepository = alunoRepository;
    }

    public List<Professor> findAll(){
        return professorRepository.findAll();
    }

    public Professor getProfessorByCref(String cref) {
        return professorRepository.findById(cref)
                .orElseThrow(() -> new RuntimeException("Professor não encontrado com CREF: " + cref));
    }

    public List<Aluno> listAlunos(String cref){
        Professor professor = professorRepository.findByCref(cref)
                .orElseThrow(() -> new RuntimeException(String.format("Professor não encontrado com o cref %s. ", cref)));
        return alunoRepository.findByProfessorCref(professor.getCref());
    }


    @Transactional
    public Professor insert(ProfessorRequestDTO professorRequestDTO){
        Usuario usuario = new Usuario();
        preencherCamposProfessor(usuario, professorRequestDTO);
        usuario.setSenha(passwordEncoder.encode(usuario.getSenha()));
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

    public Professor update(String cref, ProfessorRequestDTO professorRequestDTO) {
        Professor professor = getProfessorByCref(cref);
        Usuario usuario = professor.getUsuario();
        preencherCamposProfessor(usuario, professorRequestDTO);

        usuarioRepository.save(usuario);
        return professor;
    }

    @Transactional
    public void delete(String cref) {
        Professor professor = professorRepository.findById(cref)
                .orElseThrow(() -> new RuntimeException("Professor não encontrado"));
        professorRepository.delete(professor);
    }



}
