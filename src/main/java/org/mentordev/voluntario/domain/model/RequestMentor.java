package org.mentordev.voluntario.domain.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Table(name="request_mentor")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class RequestMentor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_mentee")
    private User mentee;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_mentor")
    private User mentor;

    @Column(nullable = false)
    private Status status;

    private LocalDate created_at;
}
