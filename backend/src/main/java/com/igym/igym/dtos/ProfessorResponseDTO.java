package com.igym.igym.dtos;

import com.igym.igym.model.*;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

public class ProfessorResponseDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private String nome;
    private String email;
    private String telefone;
    private Genero genero;
    private LocalDate dataNascimento;
    private String cpf;
    private Integer idade;

    private String cref;
    private Long usuarioId;

    public ProfessorResponseDTO() {
    }

    private List<AlunoSimplificadoDTO> alunoSimplificado;

    public ProfessorResponseDTO(Professor professor) {
        if(professor.getAlunos() != null){
            this.usuarioId = professor.getUsuario().getId();
            this.nome = professor.getUsuario().getNome();
            this.email = professor.getUsuario().getEmail();
            this.telefone = professor.getUsuario().getTelefone();
            this.genero = professor.getUsuario().getGenero();
            this.dataNascimento = professor.getUsuario().getDataNascimento();
            this.cpf = professor.getUsuario().getCpf();
            this.idade = professor.getUsuario().getIdade();
        }


        this.cref = professor.getCref();
        if(professor.getAlunos() != null){
            this.alunoSimplificado = professor.getAlunos().stream()
                    .map(AlunoSimplificadoDTO::new)
                    .collect(Collectors.toList());
        }

    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public Genero getGenero() {
        return genero;
    }

    public void setGenero(Genero genero) {
        this.genero = genero;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Integer getIdade() {
        return idade;
    }

    public void setIdade(Integer idade) {
        this.idade = idade;
    }

    public String getCref() {
        return cref;
    }

    public void setCref(String cref) {
        this.cref = cref;
    }

    public Long getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(Long usuarioId) {
        this.usuarioId = usuarioId;
    }
}
