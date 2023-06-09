package com.example.battleships.web;

import com.example.battleships.models.dtos.StartBattleDTO;
import com.example.battleships.services.BattleService;
import com.example.battleships.services.UserService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class BattleController {

    private final UserService userService;

    private final BattleService battleService;

    public BattleController(UserService userService, BattleService battleService) {
        this.userService = userService;
        this.battleService = battleService;
    }

    @PostMapping("/battle")
    public String battle(@Valid StartBattleDTO startBattleDTO,
                         BindingResult bindingResult,
                         RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("startBattleDTO", startBattleDTO);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.startBattleDTO",
                    bindingResult);

            return "redirect:/home";
        }

        this.battleService.attack(startBattleDTO);

        return "redirect:/home";
    }
}
