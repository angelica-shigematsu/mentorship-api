package org.mentordev.voluntario.service.user;

import org.mentordev.voluntario.domain.dto.ListUserDTO;
import org.mentordev.voluntario.domain.model.User;
import org.mentordev.voluntario.infra.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImplement implements UserService {

    @Autowired
    private UserRepository userRepository;


    @Override
    public ListUserDTO add(User user) {
        var userCreated = userRepository.save(user);
        return new ListUserDTO(userCreated.getId(),
                userCreated.getFullname(),
                userCreated.getEmail(),
                userCreated.getRole(),
                userCreated.getActive());
    }

    @Override
    public void update(User user, long id) {
        var userData = userRepository.getReferenceById(id);
        user.update(userData);
    }

    @Override
    public ListUserDTO listUser(long id) {
        var userData = userRepository.findById(id);

        return userData.map(user -> new ListUserDTO(
                user.getId(),
                user.getFullname(),
                user.getEmail(),
                user.getRole(),
                user.getActive())).orElse(null);
    }

    @Override
    public void disableUser(long id) {
        var userData = userRepository.getReferenceById(id);
        userData.disableUser();
    }

    @Override
    public Optional<User> findById(long id) { return userRepository.findById(id);}
}
