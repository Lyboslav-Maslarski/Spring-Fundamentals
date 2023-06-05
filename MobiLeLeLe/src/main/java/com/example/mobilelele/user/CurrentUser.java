package com.example.mobilelele.user;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

@Component
@SessionScope
public class CurrentUser {

    private String name;

    private String email;

    private boolean loggedIn;

    private boolean isAdmin;

    public void clear() {
        this.loggedIn = false;
        this.name = null;
        this.email = null;
    }

    public String getName() {
        return name;
    }

    public CurrentUser setName(String name) {
        this.name = name;
        return this;
    }

    public boolean isLoggedIn() {
        return loggedIn;
    }

    public CurrentUser setLoggedIn(boolean loggedIn) {
        this.loggedIn = loggedIn;
        return this;
    }

    public boolean isAnonymous() {
        return !loggedIn;
    }

    public boolean isAdmin() {
        return isAdmin;
    }

    public CurrentUser setAdmin(boolean admin) {
        isAdmin = admin;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public CurrentUser setEmail(String email) {
        this.email = email;
        return this;
    }
}
