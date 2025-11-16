package com.igym.igym.dtos;

import com.igym.igym.model.Genero;

import java.time.LocalDate;

public record ProfessorRequestDTO(
        String cref,
        String nome,
        String email,
        String senha,
        Integer telefone,
        Genero genero,
        LocalDate dataNascimento,
        Integer idade
){}