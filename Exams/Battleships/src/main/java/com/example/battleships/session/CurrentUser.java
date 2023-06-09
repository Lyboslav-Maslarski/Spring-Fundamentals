package com.example.battleships.session;

import com.example.battleships.models.entities.User;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

@Component
@SessionScope
public class CurrentUser {

    private Long id;
    private String fullName;

    public void login(User user) {
        this.id = user.getId();
        this.fullName = user.getFullName();
    }

    public void logout() {
        this.id = null;
        this.fullName = null;
    }

    public Long getId() {
        return id;
    }

    public CurrentUser setId(Long id) {
        this.id = id;
        return this;
    }

    public String getFullName() {
        return fullName;
    }

    public CurrentUser setFullName(String fullName) {
        this.fullName = fullName;
        return this;
    }
}
