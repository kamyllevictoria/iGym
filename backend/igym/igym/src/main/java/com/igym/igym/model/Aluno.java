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
    @Enumerated(EnumType.STRING)
    private Pagamento pagamento;

    @Column(nullable = false)
    private String pressaoArterial;

    @Column(nullable = false)
    private String historicoSaude;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private AtividadeDoPlano atividadeDoPlano;


    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private TipoDePlano tipoDePlano;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "usuario_id", referencedColumnName = "id", nullable = false)
    @JsonBackReference
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "professor_id")
    @JsonBackReference
    private Professor professor;


    public Aluno(Integer altura, Double peso, String medicamentos, String cirurgias, Pagamento pagamento, String pressaoArterial, String historicoSaude, AtividadeDoPlano atividadeDoPlano, TipoDePlano tipoDePlano, Usuario usuario) {
        this.altura = altura;
        this.peso = peso;
        this.medicamentos = medicamentos;
        this.cirurgias = cirurgias;
        this.pagamento = pagamento;
        this.pressaoArterial = pressaoArterial;
        this.historicoSaude = historicoSaude;
        this.atividadeDoPlano = atividadeDoPlano;
        this.tipoDePlano = tipoDePlano;
        this.usuario = usuario;
    }

    public Aluno() {
    }

    public Long getMatricula() {
        return matricula;
    }

    public void setMatricula(Long matricula) {
        this.matricula = matricula;
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

    public AtividadeDoPlano getAtividadeDoPlano() {
        return atividadeDoPlano;
    }

    public void setAtividadeDoPlano(AtividadeDoPlano atividadeDoPlano) {
        this.atividadeDoPlano = atividadeDoPlano;
    }

    public TipoDePlano getTipoDePlano() {
        return tipoDePlano;
    }

    public void setTipoDePlano(TipoDePlano tipoDePlano) {
        this.tipoDePlano = tipoDePlano;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Professor getProfessor() {
        return professor;
    }

    public void setProfessor(Professor professor) {
        this.professor = professor;
    }
}
