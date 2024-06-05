package com.api.bluetrip.services;

import com.api.bluetrip.controllers.dtos.user.UserUpdateDTO;
import com.api.bluetrip.models.User;
import com.api.bluetrip.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void update(Long id, UserUpdateDTO userUpdateDTO) {
        User user = userRepository.getReferenceById(id);

        user.updateInformation(userUpdateDTO);

        userRepository.save(user);
    }
}
