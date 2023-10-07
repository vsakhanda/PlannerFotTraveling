package com.planner.travel.service;

import com.planner.travel.dto.UserDTO;

import java.util.List;
import java.util.Optional;


public interface UserService {

    // Додавання користувача

    UserDTO createUser(UserDTO userSTO);
    Optional<UserDTO> getUser(int userId);
    List<UserDTO> findAllUsers();
    UserDTO updateUser(int userId, UserDTO userDTO);
    boolean deleteUser(int userId);
    Optional<UserDTO> getById(int userId);

}
