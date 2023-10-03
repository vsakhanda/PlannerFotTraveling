package com.planner.travel.service;

import com.planner.travel.dto.UserDTO;
import com.planner.travel.entity.User;

import java.util.List;
import java.util.Optional;


public interface UserService {


    UserDTO createUser(UserDTO userDTO);

    Optional<UserDTO> getUser(Long id);

    UserDTO updateUser(Long id, UserDTO userDTO);

    void deleteUser(Long id);

    List<UserDTO> findAllUsers();

    User getById(int id); // must be DTO

    //  UserDTO findById(Integer id); - повинна бути реалізація
    User add(User user);
}
