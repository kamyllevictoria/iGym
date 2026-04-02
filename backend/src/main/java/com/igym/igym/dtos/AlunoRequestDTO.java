package com.igym.igym.dtos;

import com.igym.igym.model.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.br.CPF;


import java.io.Serializable;
import java.time.LocalDate;


public class AlunoRequestDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    //dados para composicao
    @NotBlank(message = "O nome é obrigatório")
    private String nome;

    @Email(message = "Email inválido")
    @NotBlank
    private String email;

    @NotBlank
    private String senha;

    @NotBlank(message = "O telefone é obrigatório")
    private String telefone;

    @NotNull
    private Genero genero;

    @NotNull(message = "A data de nascimento é obrigatória")
    private LocalDate dataNascimento;

    @CPF(message = "CPF inválido")
    private String cpf;

    private Integer idade;


    //campos do aluno
    @NotNull(message = "Altura é obrigatória")
    private Integer altura;

    @NotNull(message = "Campo peso é obrigatório")
    private Double peso;

    private String medicamentos;

    private String cirurgias;

    @NotNull(message = "O método de pagamento é obrigatório.")
    private Pagamento pagamento;

    @NotBlank(message = "A pressaoArterial é obrigatória.")
    private String pressaoArterial;

    @NotBlank(message = "O historicoSaude é obrigatório.")
    private String historicoSaude;

    @NotNull(message = "A atividade do plano é obrigatória.")
    private AtividadeDoPlano atividadeDoPlano;

    @NotNull(message = "O tipo do plano é obrigatório.")
    private TipoDePlano tipoDePlano;

    private String professorCref;

    public AlunoRequestDTO() {
    }

    public AlunoRequestDTO(Aluno aluno) {
        this.altura = aluno.getAltura();
        this.peso = aluno.getPeso();
        this.medicamentos = aluno.getMedicamentos();
        this.cirurgias = aluno.getCirurgias();
        this.pagamento = aluno.getPagamento();
        this.pressaoArterial = aluno.getPressaoArterial();
        this.historicoSaude =aluno.getHistoricoSaude();
        this.atividadeDoPlano = aluno.getAtividadeDoPlano();
        this.tipoDePlano = aluno.getTipoDePlano();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public Genero getGenero() {
        return genero;
    }

    public void setGenero(Genero genero) {
        this.genero = genero;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
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

    public String getProfessorCref() {
        return professorCref;
    }

    public void setProfessorCref(String professorCref) {
        this.professorCref = professorCref;
    }

    public Integer getIdade() {
        return idade;
    }

    public void setIdade(Integer idade) {
        this.idade = idade;
    }
}

