package com.igym.igym.dtos;

import com.igym.igym.model.Genero;
import com.igym.igym.model.Pagamento;
import com.igym.igym.model.Plano;

import java.time.LocalDate;

public record AlunoRequestDTO(
        String nome,
        String email,
        String senha,
        Integer telefone,
        Genero genero,
        LocalDate dataNascimento,
        Integer idade,
        Integer altura,
        Double peso,
        String medicamentos,
        String cirurgias,
        Pagamento pagamento,
        String pressaoArterial,
        String historicoSaude,
        Plano plano
) {}

