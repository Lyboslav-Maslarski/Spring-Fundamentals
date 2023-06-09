package com.example.battleships.models.dtos;

import jakarta.persistence.Column;

public class ShipDTO {
    private long id;

    private String name;

    private long health;

    private long power;

    public ShipDTO() {
    }

    public long getId() {
        return id;
    }

    public ShipDTO setId(long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public ShipDTO setName(String name) {
        this.name = name;
        return this;
    }

    public long getHealth() {
        return health;
    }

    public ShipDTO setHealth(long health) {
        this.health = health;
        return this;
    }

    public long getPower() {
        return power;
    }

    public ShipDTO setPower(long power) {
        this.power = power;
        return this;
    }

    @Override
    public String toString() {
        return getName() + " -- " + getHealth() + " -- " + getPower();
    }
}
