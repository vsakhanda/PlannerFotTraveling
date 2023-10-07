package com.planner.travel.service;


import com.planner.travel.dto.TripDTO;

import java.util.List;
import java.util.Optional;

public interface TripService {


    TripDTO createTrip(TripDTO tripSTO);
    Optional<TripDTO> get(int tripId);
    List<TripDTO> findAll();
    TripDTO updateTrip(int Id, TripDTO tripDTO);
    boolean delete(int tripId);
    Optional<TripDTO> getTripById(int tripId);

}
