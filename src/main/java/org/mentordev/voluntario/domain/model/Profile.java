package org.mentordev.voluntario.domain.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.mentordev.voluntario.domain.dto.CreateProfileDTO;
import org.mentordev.voluntario.domain.dto.CreateProfileInputDTO;


@Entity
@Table(name="profile")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Profile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String bio;

    private String expertise;

    @OneToOne(cascade = CascadeType.ALL)
    private User user;

    public Profile(CreateProfileInputDTO profileDTO) {
        this.bio = profileDTO.bio();
        this.expertise = profileDTO.expert();
    }

    public Profile(CreateProfileDTO profileDTO) {
        this.bio = profileDTO.bio();
        this.expertise = profileDTO.expert();
        this.user = profileDTO.user();
    }
    public void setExpert(String expertise) {
        this.expertise = expertise;
    }
}


