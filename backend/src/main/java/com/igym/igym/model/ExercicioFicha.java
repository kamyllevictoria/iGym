package com.igym.igym.model;

import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Embeddable
public class ExercicioFicha {

    private String nome;

    private String agrupamentoMuscular;

    private int series;

    private int repeticoes;

    private String tempoDescanso;

    public ExercicioFicha(){

    }

    public ExercicioFicha(String nome, String agrupamentoMuscular, int series, int repeticoes, String tempoDescanso) {
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

