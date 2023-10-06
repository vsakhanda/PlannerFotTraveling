package com.planner.travel.service;

import com.planner.travel.dto.UserDTO;
import com.planner.travel.entity.User;

import java.util.List;
import java.util.Optional;


public interface UserService {

    // Додавання користувача

    UserDTO createUser(UserDTO userDTO);

    UserDTO findById(Integer id);



    Optional<UserDTO> getById(int userId);

    Optional<UserDTO> getUser(int id);

    UserDTO updateUser(int id, UserDTO userDTO);

    void deleteUser(int id);

    void deleteUser(Long id);

    List<UserDTO> findAllUsers();

    User getById(Integer id); // must be DTO

    // DAO layer 48.44


    //  UserDTO findById(Integer id); - повинна бути реалізація

}
