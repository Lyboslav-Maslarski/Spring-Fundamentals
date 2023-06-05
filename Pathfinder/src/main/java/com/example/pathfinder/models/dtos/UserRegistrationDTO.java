package com.example.pathfinder.models.dtos;

import jakarta.validation.constraints.*;

public class UserRegistrationDTO {

    @NotEmpty
    @Size(min = 5, max = 20)
    private String username;

    @NotEmpty
    @Size(min = 5, max = 20)
    private String fullname;

    @NotEmpty
    @Email
    private String email;

    @Min(0)
    @Max(90)
    private int age;

    @NotEmpty
    @Size(min = 5, max = 20)
    private String password;

    @NotEmpty
    @Size(min = 5, max = 20)
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

    public String getFullname() {
        return fullname;
    }

    public UserRegistrationDTO setFullname(String fullName) {
        this.fullname = fullName;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public UserRegistrationDTO setEmail(String email) {
        this.email = email;
        return this;
    }

    public int getAge() {
        return age;
    }

    public UserRegistrationDTO setAge(int age) {
        this.age = age;
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
