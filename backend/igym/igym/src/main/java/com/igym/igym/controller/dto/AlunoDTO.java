package com.igym.igym.controller.dto;

import com.igym.igym.model.Payment;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record AlunoDTO(
        @NotNull
        @NotBlank(message = "Required field.")
        String registrationNumber,

        @NotNull
        Double height,

        @NotNull
        Double weight,

        @NotBlank(message = "Required field.")
        @Size(max = 200, message = "Maximum of 200 characters.")
        String medications,

        @NotBlank(message = "Required field.")
        @Size(max = 200, message = "Maximum of 200 characters.")
        String surgeries,

        @NotNull(message = "Required field.")
        Payment payment,

        @NotBlank(message = "Required field.")
        @Size(max = 255, message = "Maximum of 255 characters.")
        String healthHistory,

        @NotBlank(message = "Required field.")
        @Size(max = 3, message = "Maximum of 3 characters.")
        String bloodPressure,

        @NotNull(message = "Required field.")
        UsuarioDTO usuarioDTO
) {}