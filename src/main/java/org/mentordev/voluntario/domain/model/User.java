package org.mentordev.voluntario.domain.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.mentordev.voluntario.domain.dto.CreateUserDTO;
import org.mentordev.voluntario.domain.dto.UpdateUserDTO;

import java.time.LocalDate;

@Entity
@Table(name="users")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    private String fullname;

    @Column(nullable = false, unique = true)
    @Pattern(regexp = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$")
    private String email;

    @Column(nullable = false)
    @Pattern(regexp = "^(?=.*[A-Za-z])(?=.*\\d)(?=.*[@$!%*?&]).{8,}")
    private String password;

    @Enumerated(EnumType.STRING)
    private Role role;

    @Column(nullable = false)
    private LocalDate created_at;

    @Column(nullable = false)
    private Boolean active;

    public User(CreateUserDTO userDTO) {
        this.fullname = userDTO.fullname();
        this.email = userDTO.email();
        this.password = userDTO.password();
        this.role = userDTO.role();
        this.active = true;
        this.created_at = LocalDate.now();
    }

    public User(UpdateUserDTO userDTO) {
        this.fullname = userDTO.fullname();
        this.email = userDTO.email();
        this.password = userDTO.password();
        this.role = userDTO.role();
        this.active = userDTO.active();
    }

    public void update(User user) {
        if (user.fullname != null) {
            this.fullname = user.getFullname();
        }

        if (user.email != null) {
            this.email = user.getEmail();
        }

        if (user.password != null) {
            this.password = user.getPassword();
        }

        if (user.role != null) {
            this.role = user.getRole();
        }

        if (user.active != null) {
            this.active = user.getActive();
        }
    }

    public void disableUser() {
        this.active = false;
    }
}
