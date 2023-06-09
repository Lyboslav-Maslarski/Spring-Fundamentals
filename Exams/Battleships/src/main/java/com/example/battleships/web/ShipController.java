package com.example.battleships.web;

import com.example.battleships.models.dtos.CreateShipDTO;
import com.example.battleships.services.ShipService;
import com.example.battleships.services.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class ShipController {

    private final ShipService shipService;
    private final UserService userService;

    @Autowired
    public ShipController(ShipService shipService, UserService userService) {
        this.shipService = shipService;
        this.userService = userService;
    }

    @ModelAttribute("createShipDTO")
    public CreateShipDTO init() {
        return new CreateShipDTO();
    }

    @GetMapping("/ships/add")
    public String addShip() {
        if (this.userService.hasNoLoggedUser()) {
            return "redirect:/";
        }

        return "/ship-add";
    }

    @PostMapping("/ships/add")
    public String addShip(@Valid CreateShipDTO createShipDTO,
                          BindingResult bindingResult,
                          RedirectAttributes redirectAttributes) {
        if (this.userService.hasNoLoggedUser()) {
            return "redirect:/";
        }

        if (bindingResult.hasErrors() || !shipService.saveShip(createShipDTO)) {
            redirectAttributes.addFlashAttribute("createShipDTO", createShipDTO);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.createShipDTO",
                    bindingResult);

            return "redirect:/ships/add";
        }


        return "redirect:/home";
    }
}
