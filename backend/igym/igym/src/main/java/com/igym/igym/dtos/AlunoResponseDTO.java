package com.igym.igym.dtos;

import com.igym.igym.model.*;

import java.io.Serializable;
import java.time.LocalDate;

public class AlunoResponseDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private String nome;
    private String email;
    private String telefone;
    private Genero genero;
    private LocalDate dataNascimento;
    private String cpf;
    private Integer idade;


    private Long matricula;
    private Integer altura;
    private Double peso;
    private String medicamentos;
    private String cirurgias;
    private Pagamento pagamento;
    private String pressaoArterial;
    private String historicoSaude;
    private AtividadeDoPlano atividadeDoPlano;
    private TipoDePlano tipoDePlano;
    private Long usuarioId;

    private String professorCref;


    public AlunoResponseDTO() {
    }

    public AlunoResponseDTO(Aluno aluno){
        if (aluno.getUsuario() != null) {
            this.usuarioId = aluno.getUsuario().getId();
            this.nome = aluno.getUsuario().getNome();
            this.email = aluno.getUsuario().getEmail();
            this.telefone = aluno.getUsuario().getTelefone();
            this.genero = aluno.getUsuario().getGenero();
            this.dataNascimento = aluno.getUsuario().getDataNascimento();
            this.cpf = aluno.getUsuario().getCpf();
            this.idade = aluno.getUsuario().getIdade();

        }

        if (aluno.getProfessor() != null) {
           this.professorCref = aluno.getProfessor().getCref();
        }

        this.matricula = aluno.getMatricula();
        this.altura = aluno.getAltura();
        this.peso = aluno.getPeso();
        this.medicamentos = aluno.getMedicamentos();
        this.cirurgias = aluno.getCirurgias();
        this.pagamento = aluno.getPagamento();
        this.pressaoArterial = aluno.getPressaoArterial();
        this.historicoSaude = aluno.getHistoricoSaude();
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

    public Integer getIdade() {
        return idade;
    }

    public void setIdade(Integer idade) {
        this.idade = idade;
    }

    public String getProfessorCref() {
      return professorCref;
    }

    public void setProfessorCref(String professorCref) {
       this.professorCref = professorCref;
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

    public Long getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(Long usuarioId) {
        this.usuarioId = usuarioId;
    }
}
