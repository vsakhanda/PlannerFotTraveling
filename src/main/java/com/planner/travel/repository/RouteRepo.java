package com.planner.travel.repository;

import com.planner.travel.entity.Route;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RouteRepo extends JpaRepository<Route, Integer > {

        Optional<Route> findRouteById (int Id);
}
