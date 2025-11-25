package com.igym.igym.dtos;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

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

    public ExercicioFichaRequestDTO(){
    }

    public ExercicioFichaRequestDTO(String nome, String agrupamentoMuscular, int series, int repeticoes, String tempoDescanso) {
        this.nome = nome;
        this.agrupamentoMuscular = agrupamentoMuscular;
        this.series = series;
        this.repeticoes = repeticoes;
        this.tempoDescanso = tempoDescanso;
    }

    public String getNome() {
        return nome;
    }

    public String getAgrupamentoMuscular() {
        return agrupamentoMuscular;
    }

    public int getSeries() {
        return series;
    }

    public int getRepeticoes() {
        return repeticoes;
    }

    public String getTempoDescanso() {
        return tempoDescanso;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setAgrupamentoMuscular(String agrupamentoMuscular) {
        this.agrupamentoMuscular = agrupamentoMuscular;
    }

    public void setSeries(int series) {
        this.series = series;
    }

    public void setRepeticoes(int repeticoes) {
        this.repeticoes = repeticoes;
    }

    public void setTempoDescanso(String tempoDescanso) {
        this.tempoDescanso = tempoDescanso;
    }
}

