package com.igym.igym.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class FichaDeTreinoRequestDTO {

    @NotBlank(message = "A frequência semanal é obrigatória.")
    private String frequenciaSemanal;

    @NotNull(message = "O ID do aluno é obrigatório.")
    private Long alunoId; // Recebe o ID do aluno

    @NotNull(message = "O ID do professor é obrigatório.")
    private Long professorId; // Recebe o ID do professor

    @NotNull(message = "A lista de exercícios não pode ser nula.")
    private List<ExercicioFichaRequestDTO> listaDeExercicios;
}
