package org.mentordev.voluntario.service.available;

import org.mentordev.voluntario.domain.dto.ListTimePossibleDTO;
import org.mentordev.voluntario.domain.model.*;
import org.mentordev.voluntario.domain.model.TimePossible;

public interface TimePossibleService {

    ListTimePossibleDTO add(TimePossible availableTime);
}
