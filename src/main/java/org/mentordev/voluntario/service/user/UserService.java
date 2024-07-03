package org.mentordev.voluntario.service.user;

import org.mentordev.voluntario.domain.dto.ListUserDTO;
import org.mentordev.voluntario.domain.model.User;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public interface UserService {

    ListUserDTO add(User user);

    void update(User user, long id);

    ListUserDTO listUser(long id);

    void disableUser(long id);

    Optional<User> findById(long id);
}
