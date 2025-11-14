package com.igym.igym.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "professores")
public class Professor implements Serializable {

    @Id
    @Column(nullable = false)
    private String cref;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "usuario", referencedColumnName = "id", nullable = false, unique = true)
    @JsonBackReference
    private Usuario usuario;

    public Professor(Usuario usuario) {
        this.usuario = usuario;
    }

    public Professor() {
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}
