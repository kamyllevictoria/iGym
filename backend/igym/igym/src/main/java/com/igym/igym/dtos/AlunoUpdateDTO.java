package com.igym.igym.dtos;

import com.igym.igym.model.AtividadeDoPlano;
import com.igym.igym.model.Pagamento;
import com.igym.igym.model.TipoDePlano;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;

import java.io.Serializable;

public class AlunoUpdateDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    @Email
    private String email;

    @Size(min = 8, message = "A senha deve conter no mínimo 8 caracteres")
    private String senha;

    private String telefone;

    private Pagamento pagamento;

    private AtividadeDoPlano atividadeDoPlano;

    private TipoDePlano tipoDePlano;


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

    public Pagamento getPagamento() {
        return pagamento;
    }

    public void setPagamento(Pagamento pagamento) {
        this.pagamento = pagamento;
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
}
