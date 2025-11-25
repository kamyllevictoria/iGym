package com.igym.igym.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.List;

public class FichaDeTreinoRequestDTO {

    @NotBlank(message = "A frequência semanal é obrigatória.")
    private String frequenciaSemanal;

    @NotNull(message = "O ID do aluno é obrigatório.")
    private Long alunoId;

    @NotNull(message = "O Cref do professor é obrigatório.")
    private String professorCref;

    @NotNull(message = "A lista de exercícios não pode ser nula.")
    private List<ExercicioFichaRequestDTO> listaDeExercicios;

    public FichaDeTreinoRequestDTO(){

    }

    public FichaDeTreinoRequestDTO(String frequenciaSemanal, Long alunoId, String professorCref, List<ExercicioFichaRequestDTO> listaDeExercicios) {
        this.frequenciaSemanal = frequenciaSemanal;
        this.alunoId = alunoId;
        this.professorCref = professorCref;
        this.listaDeExercicios = listaDeExercicios;
    }

    public String getFrequenciaSemanal() {
        return frequenciaSemanal;
    }

    public Long getAlunoId() {
        return alunoId;
    }

    public String getProfessorCref() {
        return professorCref;
    }

    public List<ExercicioFichaRequestDTO> getListaDeExercicios() {
        return listaDeExercicios;
    }

    public void setFrequenciaSemanal(String frequenciaSemanal) {
        this.frequenciaSemanal = frequenciaSemanal;
    }

    public void setAlunoId(Long alunoId) {
        this.alunoId = alunoId;
    }

    public void setProfessorCref(String professorCref) {
        this.professorCref = professorCref;
    }

    public void setListaDeExercicios(List<ExercicioFichaRequestDTO> listaDeExercicios) {
        this.listaDeExercicios = listaDeExercicios;
    }
}

