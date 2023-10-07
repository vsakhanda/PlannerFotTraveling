package com.planner.travel.service;

import com.planner.travel.dto.UserDTO;

import java.util.Optional;


public interface UserService {

    // Додавання користувача


    UserDTO createUser(UserDTO userSTO);
//    User createUser(User user);
//
//    UserDTO findUserById(Integer id);
//

//    List<UserDTO> findAllUsers();

    Optional<UserDTO> getById(int userId);

//    Optional<UserDTO> getUser(int id);
//
//    UserDTO updateUser(int id, UserDTO userDTO);
//
//    void deleteUser(int id);
//
//    void deleteUser(Long id);
//
//
//
//    User getById(Integer id); // must be DTO
//
//    // DAO layer 48.44
//
//
//    //  UserDTO findById(Integer id); - повинна бути реалізація
//
}
