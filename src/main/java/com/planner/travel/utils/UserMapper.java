package com.planner.travel.utils;

import com.planner.travel.dto.UserDTO;
import com.planner.travel.entity.User;

// Отримуємо всю інформацію про користувача

public class UserMapper {

    public UserDTO toDTO(User user) {
        UserDTO dto = new UserDTO();
        dto.setId(user.getId());
        dto.setEmail(user.getEmail());
        dto.setName(user.getName());
        dto.setSurname(user.getSurname());
        dto.setPhone(user.getPhone());
        dto.setCountry(user.getCountry());
        dto.setCity(user.getPhone());
        // Перетворення інших полів за потребою


        return dto;
    }

    public User toEntity(UserDTO userDTO) {
        User user = new User();
        user.setId(userDTO.getId());
        user.setEmail(userDTO.getEmail());
        user.setName(userDTO.getName());
        user.setSurname(userDTO.getSurname());
        user.setPhone(userDTO.getPhone());
        user.setCountry(userDTO.getCountry());
        user.setCity(userDTO.getPhone());

        // Перетворення інших полів за потребою
        return user;
    }

}
