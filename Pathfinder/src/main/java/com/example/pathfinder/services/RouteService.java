package com.example.pathfinder.services;

import com.example.pathfinder.models.entities.Route;
import com.example.pathfinder.repositories.RouteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RouteService {
    private final RouteRepository routeRepository;

    @Autowired
    public RouteService(RouteRepository routeRepository) {
        this.routeRepository = routeRepository;
    }

    public Route getMostCommented() {
        return routeRepository.findMostCommented();
    }
}
