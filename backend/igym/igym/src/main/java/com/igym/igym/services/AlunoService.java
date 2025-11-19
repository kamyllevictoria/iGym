package com.igym.igym.services;


import com.igym.igym.dtos.AlunoRequestDTO;
import com.igym.igym.dtos.AlunoUpdateDTO;
import com.igym.igym.model.Usuario;
import com.igym.igym.model.Professor;

import com.igym.igym.repositories.AlunoRepository;
import com.igym.igym.repositories.ProfessorRepository;
import com.igym.igym.repositories.UsuarioRepository;
import org.springframework.stereotype.Service;
import com.igym.igym.model.Aluno;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;


@Service
public class AlunoService {

    private AlunoRepository alunoRepository;
    private ProfessorRepository professorRepository;
    private UsuarioRepository usuarioRepository;


    public AlunoService(AlunoRepository alunoRepository, ProfessorRepository professorRepository, UsuarioRepository usuarioRepository) {
        this.alunoRepository = alunoRepository;
        this.professorRepository = professorRepository;
        this.usuarioRepository = usuarioRepository;
    }

    public List<Aluno> findAll(){
        return alunoRepository.findAll();
    }

    public Aluno findByMatricula(Long matricula){
        return alunoRepository.findByMatricula(matricula)
                .orElseThrow(() -> new RuntimeException(String.format("Não foi possível encontrar o usuário com a matrícula %s", matricula)));
    }

    public Aluno findByCpf(String cpf){
        return alunoRepository.findByCpf(cpf)
                .orElseThrow(() -> new RuntimeException(String.format("Não foi possível encontrar o usuário com o cpf %s", cpf)));
    }

    @Transactional
    public Aluno insert(AlunoRequestDTO alunoRequestDTO){
        //criar e salvar usuario
        Usuario usuario = new Usuario();
        preencherCamposUsuario(usuario, alunoRequestDTO);
        usuario = usuarioRepository.save(usuario);


        //buscar por professor se existir
        Professor professor = null;
        if(alunoRequestDTO.getProfessorCref() != null && alunoRequestDTO.getProfessorCref().isEmpty()){
            professor = professorRepository.findById(alunoRequestDTO.getProfessorCref()).orElse(null);
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





}
