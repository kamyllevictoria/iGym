package com.igym.igym.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "professores")
public class Professor implements Serializable {

    @Id
    @Column(nullable = false)
    private String cref;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "usuario_id", referencedColumnName = "id", nullable = false, unique = true)
    @JsonBackReference
    private Usuario usuario;

    @OneToMany(mappedBy = "professor")
    @JsonManagedReference
    private List<Aluno> alunos = new ArrayList<>();

    public Professor() {
    }

    public Professor(Usuario usuario) {
        this.usuario = usuario;
    }

    public String getCref() {
        return cref;
    }

    public void setCref(String cref) {
        this.cref = cref;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public List<Aluno> getAlunos() {
        return alunos;
    }

    public void setAlunos(List<Aluno> alunos) {
        this.alunos = alunos;
    }

    public Professor(String cref, Usuario usuario) {
        this.cref = cref;
        this.usuario = usuario;
    }
}
