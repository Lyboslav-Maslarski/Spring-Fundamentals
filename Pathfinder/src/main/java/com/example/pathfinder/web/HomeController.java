package com.example.pathfinder.web;

import com.example.pathfinder.models.entities.Route;
import com.example.pathfinder.services.RouteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

    private final RouteService routeService;

    @Autowired
    public HomeController(RouteService routeService) {
        this.routeService = routeService;
    }

    @RequestMapping("/")
    public String home(Model model) {
        Route route = routeService.getMostCommented();

        model.addAttribute("mostCommented", route);

        return "index";
    }
}
