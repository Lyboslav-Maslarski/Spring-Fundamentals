package com.example.battleships.web;

import com.example.battleships.models.dtos.ShipDTO;
import com.example.battleships.models.dtos.StartBattleDTO;
import com.example.battleships.services.ShipService;
import com.example.battleships.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.List;

@Controller
public class HomeController {

    private final ShipService shipService;

    private final UserService userService;

    @Autowired
    public HomeController(ShipService shipService, UserService userService) {
        this.shipService = shipService;
        this.userService = userService;
    }

    @ModelAttribute("startBattleDTO")
    public StartBattleDTO init() {
        return new StartBattleDTO();
    }

    @GetMapping("/index")
    public String loggedOutIndex() {
        if (!this.userService.hasNoLoggedUser()) {
            return "redirect:/home";
        }
        return "/index";
    }

    @GetMapping("/home")
    public String loggedInIndex(Model model) {
        if (this.userService.hasNoLoggedUser()) {
            return "redirect:/";
        }

        Long loggedUserId = this.userService.getLoggedUserId();

        List<ShipDTO> ownedShips = shipService.getShipsOwnedBy(loggedUserId);
        List<ShipDTO> enemyShips = shipService.getEnemyShips(loggedUserId);
        List<ShipDTO> allShips = shipService.getAllShips();

        model.addAttribute("ownedShips", ownedShips);
        model.addAttribute("enemyShips", enemyShips);
        model.addAttribute("allShips", allShips);
        return "/home";
    }
}
