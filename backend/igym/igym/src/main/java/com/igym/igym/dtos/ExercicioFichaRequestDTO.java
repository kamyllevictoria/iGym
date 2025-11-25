package com.igym.igym.dtos;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ExercicioFichaRequestDTO {

    @NotBlank(message = "O nome do exercício é obrigatório.")
    private String nome;

    @NotBlank(message = "O agrupamento muscular é obrigatório.")
    private String agrupamentoMuscular;

    @Min(value = 1, message = "O número de séries deve ser no mínimo 1.")
    private int series;

    @Min(value = 1, message = "O número de repetições deve ser no mínimo 1.")
    private int repeticoes;

    @NotBlank(message = "O tempo de descanso é obrigatório.")
    private String tempoDescanso;
}
