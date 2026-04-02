package com.igym.igym.dtos;

import com.igym.igym.model.Aluno;

import java.io.Serializable;

public class AlunoSimplificadoDTO implements Serializable {
    private static final long serialVersionUID = 1L;


    private Long matricula;
    private String nome;
    private String cpf;

    public AlunoSimplificadoDTO(Aluno aluno){
        this.matricula = aluno.getMatricula();
        if(aluno.getUsuario() != null){
            this.nome = aluno.getUsuario().getNome();
            this.cpf = aluno.getUsuario().getCpf();
        }
    }

    public AlunoSimplificadoDTO() {
    }

    public Long getMatricula() {
        return matricula;
    }

    public void setMatricula(Long matricula) {
        this.matricula = matricula;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
}
