package org.mentordev.voluntario.domain.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.mentordev.voluntario.domain.dto.CreateTimePossibleInputDTO;

import java.time.LocalTime;

@Entity
@Table(name="available")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class TimePossible {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String dayOfWeek;

    private LocalTime startTime;

    private LocalTime endTime;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "id_user")
    private User user;

    public TimePossible(CreateTimePossibleInputDTO availableDTO) {
        this.dayOfWeek = availableDTO.dayOfWeek();
        this.startTime = availableDTO.startTime();
        this.endTime = availableDTO.endTime();
        this.user = availableDTO.user();
    }
}
