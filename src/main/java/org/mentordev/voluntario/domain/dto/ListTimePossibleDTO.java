package org.mentordev.voluntario.domain.dto;

import org.mentordev.voluntario.domain.model.User;

import java.time.LocalTime;

public record ListTimePossibleDTO(
        long id,
        String dayOfWeek,

        LocalTime startTime,

        LocalTime endTime,
        java.util.Optional<User> user) {
}
