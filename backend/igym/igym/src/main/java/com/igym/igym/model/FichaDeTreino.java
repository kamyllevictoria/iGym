package com.igym.igym.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Entity
public class FichaDeTreino {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate dataCriacao = LocalDate.now();

    @NonNull
    private String frequenciaSemanal;

    @NonNull
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "aluno_id", nullable = false)
    private Aluno aluno;

    @NonNull
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "professor_cref", nullable = false)
    private Professor professor;

    @ElementCollection
    @CollectionTable(name = "ficha_exercicios", joinColumns = @JoinColumn(name = "ficha_id"))
    private List<ExercicioFicha> listaDeExercicios;

    public FichaDeTreino(){

    }

    public FichaDeTreino(Long id, LocalDate dataCriacao, @NonNull String frequenciaSemanal, @NonNull Aluno aluno, @NonNull Professor professor, List<ExercicioFicha> listaDeExercicios) {
        this.id = id;
        this.dataCriacao = dataCriacao;
        this.frequenciaSemanal = frequenciaSemanal;
        this.aluno = aluno;
        this.professor = professor;
        this.listaDeExercicios = listaDeExercicios;
    }

    public Long getId() {
        return id;
    }

    public LocalDate getDataCriacao() {
        return dataCriacao;
    }

    public @NonNull String getFrequenciaSemanal() {
        return frequenciaSemanal;
    }

    public @NonNull Aluno getAluno() {
        return aluno;
    }

    public @NonNull Professor getProfessor() {
        return professor;
    }

    public List<ExercicioFicha> getListaDeExercicios() {
        return listaDeExercicios;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setDataCriacao(LocalDate dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    public void setFrequenciaSemanal(@NonNull String frequenciaSemanal) {
        this.frequenciaSemanal = frequenciaSemanal;
    }

    public void setAluno(@NonNull Aluno aluno) {
        this.aluno = aluno;
    }

    public void setProfessor(@NonNull Professor professor) {
        this.professor = professor;
    }

    public void setListaDeExercicios(List<ExercicioFicha> listaDeExercicios) {
        this.listaDeExercicios = listaDeExercicios;
    }
}

