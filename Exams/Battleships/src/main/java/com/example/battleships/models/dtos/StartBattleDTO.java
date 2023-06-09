package com.example.battleships.models.dtos;

import jakarta.validation.constraints.Positive;

public class StartBattleDTO {

    @Positive
    private long attackedId;

    @Positive
    private long defenderId;

    public long getAttackedId() {
        return attackedId;
    }

    public StartBattleDTO setAttackedId(long attackedId) {
        this.attackedId = attackedId;
        return this;
    }

    public long getDefenderId() {
        return defenderId;
    }

    public StartBattleDTO setDefenderId(long defenderId) {
        this.defenderId = defenderId;
        return this;
    }
}
