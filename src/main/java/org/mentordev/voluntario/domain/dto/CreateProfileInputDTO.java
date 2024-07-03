package org.mentordev.voluntario.domain.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record CreateProfileInputDTO(
        @NotBlank
        String bio,

        @NotBlank
        String expert,

        @NotNull
        long idUser) {
}
