package com.example.pathfinder.services;

import com.example.pathfinder.models.dtos.UserRegistrationDTO;
import com.example.pathfinder.models.entities.User;
import com.example.pathfinder.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public boolean register(UserRegistrationDTO userRegistrationDTO) {

        Optional<User> optionalUser = this.userRepository.findByEmail(userRegistrationDTO.getEmail());

        if (optionalUser.isPresent()) {
            return false;
        }

        User user = new User()
                .setFullName(userRegistrationDTO.getFullname())
                .setAge(userRegistrationDTO.getAge())
                .setEmail(userRegistrationDTO.getEmail())
                .setUsername(userRegistrationDTO.getUsername())
                .setPassword(userRegistrationDTO.getPassword());

        userRepository.save(user);

        return true;
    }
}
