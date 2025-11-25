package com.igym.igym.model;

import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Embeddable
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ExercicioFicha {

    private String nome;

    private String agrupamentoMuscular;

    private int series;

    private int repeticoes;

    private String tempoDescanso;

}

