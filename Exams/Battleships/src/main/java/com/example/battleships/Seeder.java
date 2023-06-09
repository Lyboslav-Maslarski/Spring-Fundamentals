package com.example.battleships;

import com.example.battleships.models.entities.Category;
import com.example.battleships.models.enums.ShipType;
import com.example.battleships.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
public class Seeder implements CommandLineRunner {

    private final CategoryRepository categoryRepository;

    @Autowired
    public Seeder(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        if (categoryRepository.count() == 0) {
            Arrays.stream(ShipType.values())
                    .map(categoryEnum -> new Category().setName(categoryEnum).setDescription(categoryEnum.name()))
                    .forEach(categoryRepository::save);
        }
    }
}
