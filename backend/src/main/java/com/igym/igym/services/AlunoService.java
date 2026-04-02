package com.igym.igym.services;


import com.igym.igym.dtos.AlunoRequestDTO;
import com.igym.igym.exceptions.AlunoNotFoundException;
import com.igym.igym.model.Role;
import com.igym.igym.model.Usuario;
import com.igym.igym.model.Professor;

import com.igym.igym.repositories.AlunoRepository;
import com.igym.igym.repositories.ProfessorRepository;
import com.igym.igym.repositories.UsuarioRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import com.igym.igym.model.Aluno;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;
import java.util.Random;


@Service
public class AlunoService {

    private AlunoRepository alunoRepository;
    private ProfessorRepository professorRepository;
    private UsuarioRepository usuarioRepository;
    private PasswordEncoder passwordEncoder;

    public AlunoService(AlunoRepository alunoRepository, ProfessorRepository professorRepository, UsuarioRepository usuarioRepository, PasswordEncoder passwordEncoder) {
        this.alunoRepository = alunoRepository;
        this.professorRepository = professorRepository;
        this.usuarioRepository = usuarioRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public List<Aluno> findAll(){
        return alunoRepository.findAll();
    }

    public Aluno findByMatricula(Long matricula){
        return alunoRepository.findByMatricula(matricula)
                .orElseThrow(() -> new AlunoNotFoundException(String.format("Não foi possível encontrar o usuário com a matrícula %s", matricula)));
    }

    public Aluno findByCpf(String cpf){
        return alunoRepository.findByCpf(cpf)
                .orElseThrow(() -> new AlunoNotFoundException(String.format("Não foi possível encontrar o usuário com o cpf %s", cpf)));
    }

    public Aluno findByUsuarioId(Long usuarioId){
        return alunoRepository.findByUsuarioId(usuarioId)
                .orElseThrow(() -> new AlunoNotFoundException(String.format("Não foi possível encontrar o usuário com o id %s", usuarioId)));

    }

    @Transactional
    public Aluno insert(AlunoRequestDTO alunoRequestDTO){

        if(usuarioRepository.findByEmail(alunoRequestDTO.getEmail()).isPresent()){
            throw new RuntimeException("Email já cadastrado: " + alunoRequestDTO.getEmail());
        }
        //criar e salvar usuario
        Usuario usuario = new Usuario();

        preencherCamposUsuario(usuario, alunoRequestDTO);

        usuario.setSenha(passwordEncoder.encode(alunoRequestDTO.getSenha()));
        usuario.setRole(Role.ROLE_ALUNO);
        usuario = usuarioRepository.save(usuario);


        //buscar por professor se existir
        Professor professor = null;
        if(alunoRequestDTO.getProfessorCref() != null && !alunoRequestDTO.getProfessorCref().isEmpty()){
            professor = professorRepository.findByCref(alunoRequestDTO.getProfessorCref()).orElse(null);
        }

        //criar aluno e veincular ao usuario
        Aluno aluno = new Aluno();
        preencherCamposAluno(aluno, alunoRequestDTO);

        aluno.setUsuario(usuario);
        aluno.setProfessor(professor);
        return alunoRepository.save(aluno);
    }

    private void preencherCamposUsuario(Usuario usuario, AlunoRequestDTO dto) {
        usuario.setNome(dto.getNome());
        usuario.setEmail(dto.getEmail());
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

    private void preencherCamposAluno(Aluno aluno, AlunoRequestDTO dto){
        if(dto.getAltura() != null) aluno.setAltura(dto.getAltura());
        if(dto.getPeso() != null) aluno.setPeso(dto.getPeso());
        if(dto.getMedicamentos() != null) aluno.setMedicamentos(dto.getMedicamentos());
        if(dto.getCirurgias() != null) aluno.setCirurgias(dto.getCirurgias());
        if(dto.getPagamento() != null) aluno.setPagamento(dto.getPagamento());
        if(dto.getPressaoArterial() != null) aluno.setPressaoArterial(dto.getPressaoArterial());
        if(dto.getHistoricoSaude() != null) aluno.setHistoricoSaude(dto.getHistoricoSaude());
        if(dto.getAtividadeDoPlano() != null) aluno.setAtividadeDoPlano(dto.getAtividadeDoPlano());
        if(dto.getTipoDePlano() != null) aluno.setTipoDePlano(dto.getTipoDePlano());

    }


    @Transactional
    public Aluno update(Long matricula, AlunoRequestDTO alunoRequestDTO){

        //bucar aluno
        Aluno alunoExistente = alunoRepository.findByMatricula(matricula)
                .orElseThrow( ()-> new RuntimeException(String.format("Aluno com a matricula %s não identificado para atualização.", matricula)));

        //atualiza dados do usuario, classe pai
        Usuario usuarioExistente = alunoExistente.getUsuario();
        preencherCamposUsuario(usuarioExistente, alunoRequestDTO);
        usuarioRepository.save(usuarioExistente);

        //atualiza dados do aluno, classe filha
        preencherCamposAluno(alunoExistente, alunoRequestDTO);

        //atualizar professor se vir na requisição.
        if(alunoRequestDTO.getProfessorCref() != null && !alunoRequestDTO.getProfessorCref().isEmpty()){
            Professor professor = professorRepository.findByCref(alunoRequestDTO.getProfessorCref())
                    .orElseThrow( () -> new RuntimeException(String.format("Professor com CREF %s não encontrado.", alunoRequestDTO.getProfessorCref())));

        alunoExistente.setProfessor(professor);
        }

        return alunoRepository.save(alunoExistente);

    }

    public void deleteByCpf(String cpf){
        if(cpf == null || cpf.isBlank()){
            throw new IllegalArgumentException("Não foi possível deletar um usuário que não possui cadastro no sistema.");
        }

        Aluno aluno =  alunoRepository.findByCpf(cpf)
                .orElseThrow(() -> new EntityNotFoundException(String.format("Nenhum aluno encontrado com o cpf %s. ", cpf)));

        alunoRepository.delete(aluno);
    }

    public void deleteByMatricula(Long matricula){
        if(matricula == null){
            throw new IllegalArgumentException("Não foi possível deletar um usuário que não possui cadastro no sistema.");
        }

        Aluno aluno =  alunoRepository.findByMatricula(matricula)
                .orElseThrow(() -> new EntityNotFoundException(String.format("Nenhum aluno encontrado com a matricula: %s. ", matricula)));

        alunoRepository.delete(aluno);
    }




}
