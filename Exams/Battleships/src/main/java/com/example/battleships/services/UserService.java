package com.example.battleships.services;

import com.example.battleships.models.dtos.LoginDTO;
import com.example.battleships.models.dtos.UserRegistrationDTO;
import com.example.battleships.models.entities.User;
import com.example.battleships.repositories.UserRepository;
import com.example.battleships.session.CurrentUser;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    private final ModelMapper modelMapper;

    private final UserRepository userRepository;

    private final CurrentUser currentUser;

    @Autowired
    public UserService(ModelMapper modelMapper, UserRepository userRepository, CurrentUser currentUser) {
        this.modelMapper = modelMapper;
        this.userRepository = userRepository;
        this.currentUser = currentUser;
    }

    public void register(UserRegistrationDTO userRegistrationDTO) {
        User user = modelMapper.map(userRegistrationDTO, User.class);

        userRepository.save(user);
    }

    public boolean login(LoginDTO loginDTO) {
        Optional<User> user = this.userRepository.findByUsernameAndPassword(loginDTO.getUsername(), loginDTO.getPassword());
        if (user.isEmpty()) {
            return false;
        }

        currentUser.login(user.get());

        return true;
    }

    public void logoutUser() {
        currentUser.logout();
    }

    public boolean hasNoLoggedUser() {
        return currentUser.getId() == null;
    }

    public Long getLoggedUserId() {
        return currentUser.getId();
    }
}
