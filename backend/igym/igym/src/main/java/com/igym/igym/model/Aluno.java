package com.igym.igym.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "alunos")
public class Aluno implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long matricula;

    @Column(nullable = false)
    private Integer altura;

    @Column(nullable = false)
    private Double peso;

    @Column(nullable = false)
    private String medicamentos;

    @Column(nullable = false)
    private String cirurgias;

    @Column(nullable = false)
    private Pagamento pagamento;

    @Column(nullable = false)
    private String pressaoArterial;

    @Column(nullable = false)
    private String historicoSaude;

    @Column(nullable = false)
    private Plano plano;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "usuario", referencedColumnName = "id", nullable = false, unique = true)
    @JsonBackReference
    private Usuario usuario;


    public Aluno(Integer altura, Double peso, String medicamentos, String cirurgias, Pagamento pagamento, String pressaoArterial, String historicoSaude, Plano plano, Usuario usuario) {
        this.altura = altura;
        this.peso = peso;
        this.medicamentos = medicamentos;
        this.cirurgias = cirurgias;
        this.pagamento = pagamento;
        this.pressaoArterial = pressaoArterial;
        this.historicoSaude = historicoSaude;
        this.plano = plano;
        this.usuario = usuario;
    }

    public Aluno() {
    }

    public Integer getAltura() {
        return altura;
    }

    public void setAltura(Integer altura) {
        this.altura = altura;
    }

    public Double getPeso() {
        return peso;
    }

    public void setPeso(Double peso) {
        this.peso = peso;
    }

    public String getMedicamentos() {
        return medicamentos;
    }

    public void setMedicamentos(String medicamentos) {
        this.medicamentos = medicamentos;
    }

    public String getCirurgias() {
        return cirurgias;
    }

    public void setCirurgias(String cirurgias) {
        this.cirurgias = cirurgias;
    }

    public Pagamento getPagamento() {
        return pagamento;
    }

    public void setPagamento(Pagamento pagamento) {
        this.pagamento = pagamento;
    }

    public String getPressaoArterial() {
        return pressaoArterial;
    }

    public void setPressaoArterial(String pressaoArterial) {
        this.pressaoArterial = pressaoArterial;
    }

    public String getHistoricoSaude() {
        return historicoSaude;
    }

    public void setHistoricoSaude(String historicoSaude) {
        this.historicoSaude = historicoSaude;
    }

    public Plano getPlano() {
        return plano;
    }

    public void setPlano(Plano plano) {
        this.plano = plano;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}
