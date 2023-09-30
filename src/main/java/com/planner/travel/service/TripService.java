package com.planner.travel.service;

import com.planner.travel.model.Trip;

public interface TripService {


    Trip getById(int id); // must be DTO

    //  UserDTO findById(Integer id); - повинна бути реалізація
    Trip add(Trip trip);

}
