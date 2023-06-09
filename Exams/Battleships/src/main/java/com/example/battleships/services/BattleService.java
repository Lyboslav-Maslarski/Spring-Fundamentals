package com.example.battleships.services;

import com.example.battleships.models.dtos.StartBattleDTO;
import com.example.battleships.models.entities.Ship;
import com.example.battleships.repositories.ShipRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class BattleService {
    private final ShipRepository shipRepository;

    @Autowired
    public BattleService(ShipRepository shipRepository) {
        this.shipRepository = shipRepository;
    }

    public void attack(StartBattleDTO startBattleDTO) {
        Optional<Ship> optionalAttacker = this.shipRepository.findById(startBattleDTO.getAttackedId());
        Optional<Ship> optionalDefender = this.shipRepository.findById(startBattleDTO.getDefenderId());

        if (optionalAttacker.isEmpty() || optionalDefender.isEmpty()) {
            throw new NoSuchElementException();
        }

        Ship attacker = optionalAttacker.get();
        Ship defender = optionalDefender.get();

        long defenderHealth = defender.getHealth() - attacker.getPower();

        if (defenderHealth <= 0) {
            this.shipRepository.delete(defender);
        }

        defender.setHealth(defenderHealth);
        this.shipRepository.save(defender);
    }
}
