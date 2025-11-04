package com.igym.igym.controller.dto;

import com.igym.igym.model.Gender;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.time.LocalDate;

public record UserDTO(
        Integer id,
        String name,
        String email,
        String password,
        Integer phoneNumber,
        Gender gender,
        LocalDate birthDate,
        String CPF,
        Integer age
) {
}

