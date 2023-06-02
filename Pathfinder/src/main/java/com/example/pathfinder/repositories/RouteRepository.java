package com.example.pathfinder.repositories;

import com.example.pathfinder.models.entities.Route;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface RouteRepository extends JpaRepository<Route,Long> {

    @Transactional
    @Query("SELECT r from Route r order by size(r.comments) desc limit 1")
    Route findMostCommented();
}
