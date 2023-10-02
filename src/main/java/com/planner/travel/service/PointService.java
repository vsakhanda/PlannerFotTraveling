package com.planner.travel.service;

import com.planner.travel.entity.Point;

public interface PointService {

    Point getById(int id); // must be DTO

    //  UserDTO findById(Integer id); - повинна бути реалізація
    Point add(Point point);


}
