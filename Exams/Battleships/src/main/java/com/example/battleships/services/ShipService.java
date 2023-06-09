package com.example.battleships.services;

import com.example.battleships.models.dtos.CreateShipDTO;
import com.example.battleships.models.entities.Category;
import com.example.battleships.models.entities.Ship;
import com.example.battleships.models.entities.User;
import com.example.battleships.models.enums.ShipType;
import com.example.battleships.repositories.CategoryRepository;
import com.example.battleships.repositories.ShipRepository;
import com.example.battleships.repositories.UserRepository;
import com.example.battleships.session.CurrentUser;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ShipService {

    private final ShipRepository shipRepository;

    private final ModelMapper modelMapper;

    private final CategoryRepository categoryRepository;

    private final UserRepository userRepository;

    private final CurrentUser currentUser;

    @Autowired
    public ShipService(ShipRepository shipRepository, ModelMapper modelMapper,
                       CategoryRepository categoryRepository, UserRepository userRepository,
                       CurrentUser currentUser) {
        this.shipRepository = shipRepository;
        this.modelMapper = modelMapper;
        this.categoryRepository = categoryRepository;
        this.userRepository = userRepository;
        this.currentUser = currentUser;
    }

    public boolean saveShip(CreateShipDTO createShipDTO) {
        Optional<Ship> optional = shipRepository.findByName(createShipDTO.getName());
        if (optional.isPresent()) {
            return false;
        }

        Ship ship = modelMapper.map(createShipDTO, Ship.class);

        ShipType shipType = createShipDTO.getCategory();
        Optional<Category> category = categoryRepository.findByName(shipType);
        if (category.isEmpty()) {
            return false;
        }
        ship.setCategory(category.get());

        Optional<User> user = userRepository.findById(currentUser.getId());
        ship.setUser(user.get());

        shipRepository.save(ship);
        return true;
    }
}
