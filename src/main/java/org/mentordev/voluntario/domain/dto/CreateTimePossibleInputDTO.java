package org.mentordev.voluntario.domain.dto;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.mentordev.voluntario.domain.model.User;

import java.time.LocalTime;

public record CreateTimePossibleInputDTO(
        @NotBlank
        String dayOfWeek,

        @NotNull
        LocalTime startTime,

        @NotNull
        LocalTime endTime,
        @NotBlank
        User user) {
}
