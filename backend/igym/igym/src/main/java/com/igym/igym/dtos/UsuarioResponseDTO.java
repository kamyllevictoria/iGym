package com.igym.igym.dtos;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.igym.igym.model.Genero;
import com.igym.igym.model.Usuario;

import java.time.LocalDate;

public class UsuarioResponseDTO {

    private String nome;
    private String email;
    private Long id;
    private String telefone;
    private Genero genero;
    private LocalDate dataNascimento;
    private Integer idade;

    public UsuarioResponseDTO() {
    }
    public UsuarioResponseDTO(Usuario usuario) {
        id = usuario.getId();
        nome = usuario.getNome();
        email = usuario.getEmail();
        telefone = usuario.getTelefone();
        genero = usuario.getGenero();
        this.dataNascimento = usuario.getDataNascimento();
        idade = usuario.getIdade();
    }

    public UsuarioResponseDTO(UsuarioRequestDTO usuarioRequestDTO) {
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Integer getIdade() {
        return idade;
    }

    public void setIdade(Integer idade) {
        this.idade = idade;
    }
}
