package com.igym.igym.controller.dto;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record TeacherDTO(

        @NotBlank(message = "Required field.")
        @Size(min = 7, max = 7)
        String cref,

        @NotNull(message = "Required field.")
        UserDTO UserDTO
) {
}
