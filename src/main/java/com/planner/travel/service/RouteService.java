package com.planner.travel.service;

import com.planner.travel.entity.Route;

public interface RouteService {


    Route getById(int id); // must be DTO

    //  UserDTO findById(Integer id); - повинна бути реалізація
    Route add(Route route);


}
