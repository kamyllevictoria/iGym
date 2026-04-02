package com.igym.igym.dtos;

import java.util.List;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import com.igym.igym.model.ExercicioFicha;

public class FichaDeTreinoUpdateDTO {

    @NotBlank(message = "A frequência semanal é obrigatória.")
    private String frequenciaSemanal;

    @NotNull(message = "A lista de exercícios não pode ser nula.")
    private List<ExercicioFichaRequestDTO> listaDeExercicios;

    public FichaDeTreinoUpdateDTO() {
    }

    public FichaDeTreinoUpdateDTO(String frequenciaSemanal, List<ExercicioFichaRequestDTO> listaDeExercicios) {
        this.frequenciaSemanal = frequenciaSemanal;
        this.listaDeExercicios = listaDeExercicios;
    }

    public String getFrequenciaSemanal() {
        return frequenciaSemanal;
    }

    public List<ExercicioFichaRequestDTO> getListaDeExercicios() {
        return listaDeExercicios;
    }

    public void setFrequenciaSemanal(String frequenciaSemanal) {
        this.frequenciaSemanal = frequenciaSemanal;
    }

    public void setListaDeExercicios(List<ExercicioFichaRequestDTO> listaDeExercicios) {
        this.listaDeExercicios = listaDeExercicios;
    }
}