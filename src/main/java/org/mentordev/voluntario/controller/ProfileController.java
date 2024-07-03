package org.mentordev.voluntario.controller;

import jakarta.validation.Valid;
import org.mentordev.voluntario.domain.dto.CreateProfileDTO;
import org.mentordev.voluntario.domain.dto.CreateProfileInputDTO;
import org.mentordev.voluntario.domain.dto.ListProfileDTO;
import org.mentordev.voluntario.domain.model.Profile;
import org.mentordev.voluntario.service.profile.ProfileService;
import org.mentordev.voluntario.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/profile")
public class ProfileController {

    @Autowired
    private ProfileService profileService;

    @Autowired
    private UserService userService;

    @PostMapping
    public ResponseEntity<ListProfileDTO> createProfile(@RequestBody @Valid CreateProfileInputDTO profileInputDTO) {
        var user = userService.findById(profileInputDTO.idUser()).get();

        var profileDTO = new CreateProfileDTO(profileInputDTO.bio(), profileInputDTO.expert(), user);
        return ResponseEntity.ok(profileService.add(new Profile(profileDTO)));
    }
}
