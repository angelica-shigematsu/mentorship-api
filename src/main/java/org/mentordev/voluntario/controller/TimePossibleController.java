package org.mentordev.voluntario.controller;

import jakarta.validation.Valid;
import org.mentordev.voluntario.domain.dto.CreateTimePossibleDTO;
import org.mentordev.voluntario.domain.dto.CreateTimePossibleInputDTO;

import org.mentordev.voluntario.domain.model.TimePossible;
import org.mentordev.voluntario.domain.model.User;
import org.mentordev.voluntario.service.available.TimePossibleService;
import org.mentordev.voluntario.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/time")
public class TimePossibleController {

    @Autowired
    private TimePossibleService availableService;

    @Autowired
    private UserService userService;

    @PostMapping
    public ResponseEntity createAvailableTime(@RequestBody @Valid CreateTimePossibleDTO availableDTO) {
        User userData = userService.findById(availableDTO.idUser()).get();

        var available = new CreateTimePossibleInputDTO(
                availableDTO.dayOfWeek(),
                availableDTO.startTime(),
                availableDTO.endTime(),
                userData);

        var result = availableService.add(new TimePossible(available));

        if (result == null) return ResponseEntity.badRequest().body("Horário ou dia da semana incorreta ou já registrada");

        return ResponseEntity.ok(result);

    }

}
