package org.mentordev.voluntario.service.available;

import org.mentordev.voluntario.domain.dto.ListTimePossibleDTO;
import org.mentordev.voluntario.domain.model.TimePossible;
import org.mentordev.voluntario.infra.repository.TimePossibleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalTime;
import java.util.Collections;
import java.util.Optional;

@Service
public class TimePossibleServiceImplement implements TimePossibleService {

    @Autowired
    private TimePossibleRepository availableTimeRepository;

    public ListTimePossibleDTO add(TimePossible avalAvailableTime) {

        var timePossibleRegister = availableTimeRepository.findAllById(Collections.singleton(avalAvailableTime.getUser().getId()));

        String dayOfWeek = avalAvailableTime.getDayOfWeek();

        LocalTime startTime = avalAvailableTime.getStartTime();

        LocalTime endTime = avalAvailableTime.getEndTime();

        if (startTime.isAfter(endTime)) return null;

        for(TimePossible t: timePossibleRegister) {
            if (t.getStartTime().compareTo(startTime) > 0  && t.getEndTime().compareTo(endTime) > 0 && t.getDayOfWeek().equalsIgnoreCase(dayOfWeek)) {
                return null;
            }
            if (t.getStartTime().compareTo(startTime) > 0 && t.getDayOfWeek().equalsIgnoreCase(dayOfWeek)) {
                return null;
            }
        }

        if (dayOfWeek.equalsIgnoreCase("sábado")) return null;

        if (dayOfWeek.equalsIgnoreCase("domingo")) return null;

        var availableCreated = availableTimeRepository.save(avalAvailableTime);

        return new ListTimePossibleDTO(
                availableCreated.getId(),
                availableCreated.getDayOfWeek(),
                availableCreated.getStartTime(),
                availableCreated.getEndTime(),
                Optional.ofNullable(availableCreated.getUser()));
    }
}
