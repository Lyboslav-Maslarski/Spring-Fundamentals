package com.example.mobilelele.services;

import com.example.mobilelele.models.mapper.UserMapper;
import com.example.mobilelele.models.dto.user.UserLoginDTO;
import com.example.mobilelele.models.dto.user.UserRegisterDTO;
import com.example.mobilelele.models.entity.User;
import com.example.mobilelele.models.enums.RoleEnum;
import com.example.mobilelele.repositories.UserRepository;
import com.example.mobilelele.user.CurrentUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;

    private final CurrentUser currentUser;

    private final PasswordEncoder passwordEncoder;

    private final UserMapper userMapper;

    @Autowired
    public UserService(UserRepository userRepository, CurrentUser currentUser,
                       PasswordEncoder passwordEncoder, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.currentUser = currentUser;
        this.passwordEncoder = passwordEncoder;
        this.userMapper = userMapper;
    }

    public boolean login(UserLoginDTO userLoginDTO) {
        Optional<User> user = userRepository.findByEmail(userLoginDTO.getUsername());

        if (user.isEmpty()) {
            return false;
        }

        String rawPassword = userLoginDTO.getPassword();
        String encodedPassword = user.get().getPassword();

        boolean success = passwordEncoder.matches(rawPassword, encodedPassword);

        if (success) {
            login(user.get());
        } else {
            logout();
        }

        return success;
    }

    private void login(User user) {
        this.currentUser.setLoggedIn(true).setName(user.getFirstName() + " " + user.getLastName())
                .setAdmin(user.getRoles().stream().anyMatch(role -> role.getRole().equals(RoleEnum.ADMIN)));
    }

    public void logout() {
        currentUser.clear();
    }

    public void registerAndLogin(UserRegisterDTO userRegisterDTO) {
        User newUser = userMapper.userDTOToUser(userRegisterDTO);
        newUser.setPassword(passwordEncoder.encode(userRegisterDTO.getPassword()));

        userRepository.save(newUser);

        login(newUser);
    }
}
