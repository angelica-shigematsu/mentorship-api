package org.mentordev.voluntario.service.available;

import org.mentordev.voluntario.domain.dto.GetHoursAvailableByDayWeekDto;
import org.mentordev.voluntario.domain.dto.ListTimePossibleDTO;
import org.mentordev.voluntario.domain.dto.TimePossibleDTO;
import org.mentordev.voluntario.domain.model.*;
import org.mentordev.voluntario.domain.model.TimePossible;

import java.util.List;

public interface TimePossibleService {

    ListTimePossibleDTO add(TimePossible availableTime);

    List<TimePossibleDTO> listAllDayAvailable(GetHoursAvailableByDayWeekDto getAvailableDto);
}
