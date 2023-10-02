package com.planner.travel.service;

import com.planner.travel.entity.User;

public interface UserService {

    User getById(int id); // must be DTO

    //  UserDTO findById(Integer id); - повинна бути реалізація
    User add(User user);
}
