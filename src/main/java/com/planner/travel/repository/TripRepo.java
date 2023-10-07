package com.planner.travel.repository;

import com.planner.travel.entity.Trip;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TripRepo  extends JpaRepository<Trip, Integer > {

    Optional<Trip> findTripById (int id);

}

