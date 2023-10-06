package com.planner.travel.service;

import com.planner.travel.dto.UserDTO;
import com.planner.travel.entity.User;

import java.util.List;
import java.util.Optional;


public interface UserService {

    // Додавання користувача

    User createUser(User user);

    UserDTO findUserById(Integer id);


    List<UserDTO> findAllUsers();

    Optional<UserDTO> getById(int userId);

    Optional<UserDTO> getUser(int id);

    UserDTO updateUser(int id, UserDTO userDTO);

    void deleteUser(int id);

    void deleteUser(Long id);



    User getById(Integer id); // must be DTO

    // DAO layer 48.44


    //  UserDTO findById(Integer id); - повинна бути реалізація

}
