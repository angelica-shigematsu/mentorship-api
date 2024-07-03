package org.mentordev.voluntario.controller;

import jakarta.validation.Valid;
import org.mentordev.voluntario.domain.dto.ListUserDTO;
import org.mentordev.voluntario.domain.dto.CreateUserDTO;
import org.mentordev.voluntario.domain.dto.UpdateUserDTO;
import org.mentordev.voluntario.domain.model.User;
import org.mentordev.voluntario.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    UserService userService;

    @PostMapping
    public ResponseEntity<ListUserDTO> createUser(@RequestBody @Valid CreateUserDTO userDto) {
        return ResponseEntity.ok(userService.add(new User(userDto)));
    }

    @PutMapping("/{id}")
    public ResponseEntity updateUser(@RequestBody @Valid UpdateUserDTO userDTO, @PathVariable long id) {
        userService.update(new User(userDTO), id);
        return ResponseEntity.ok("Usuário atualizado");
    }

    @GetMapping("/{id}")
    public ResponseEntity<ListUserDTO> listUser(@PathVariable long id) {
        return ResponseEntity.ok(userService.listUser(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteUser(@PathVariable long id) {
        userService.disableUser(id);
        return ResponseEntity.ok("Usuário desabilitado");
    }
}
