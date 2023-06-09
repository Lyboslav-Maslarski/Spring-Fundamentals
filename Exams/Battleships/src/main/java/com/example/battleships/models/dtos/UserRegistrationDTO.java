package com.example.battleships.models.dtos;

import com.example.battleships.validations.FieldMatch;
import com.example.battleships.validations.UniqueEmail;
import com.example.battleships.validations.UniqueUsername;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

@FieldMatch(first = "password", second = "confirmPassword",
        message = "Password and confirmPassword must match.")
public class UserRegistrationDTO {

    @NotBlank(message = "Username is required.")
    @Size(min = 3, max = 10,message = "Username should be between 3 and 10 symbols.")
    @UniqueUsername(message = "Username should be unique.")
    private String username;

    @NotBlank
    @Size(min = 5, max = 20)
    private String fullName;

    @NotEmpty(message = "User email should be provided.")
    @Email(message = "User email should be valid.")
    @UniqueEmail(message = "User email should be unique.")
    private String email;

    @NotBlank
    @Size(min = 3)
    private String password;

    @NotBlank
    private String confirmPassword;

    public UserRegistrationDTO() {
    }

    public String getUsername() {
        return username;
    }

    public UserRegistrationDTO setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getFullName() {
        return fullName;
    }

    public UserRegistrationDTO setFullName(String fullName) {
        this.fullName = fullName;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public UserRegistrationDTO setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public UserRegistrationDTO setPassword(String password) {
        this.password = password;
        return this;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public UserRegistrationDTO setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
        return this;
    }
}
