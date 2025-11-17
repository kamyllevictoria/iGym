package com.igym.igym.dtos;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.igym.igym.model.Genero;
import com.igym.igym.model.Usuario;
import jakarta.validation.constraints.Email;
import org.hibernate.validator.constraints.br.CPF;

import java.time.LocalDate;

public class UsuarioRequestDTO {

    private String nome;

    @Email
    private String email;
    private String senha;
    private String telefone;
    private Genero genero;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate dataNascimento;

    @CPF
    private String cpf;

    public UsuarioRequestDTO() {
    }

    public UsuarioRequestDTO(Usuario usuario) {
        nome = usuario.getNome();
        email = usuario.getEmail();
        telefone = usuario.getTelefone();
        genero = usuario.getGenero();
        this.dataNascimento = usuario.getDataNascimento();
        cpf = usuario.getCpf();
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

    public String getSenha() {
        return senha;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public void setSenha(String senha) {
        this.senha = senha;
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
}

