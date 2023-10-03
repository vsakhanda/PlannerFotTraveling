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
        // Перетворення інших полів за потребою

//       (1L, user.getId());
//      ("test@example.com", user.getEmail());
//      "ALEX", user.getName());
//      s("Example.com", user.getSurname());
//     s("070707070707", user.getPhone());
//       ("Japan", user.getCountry());
//       "Tokyo", user.getCity());

        return dto;
    }

    public User toEntity(UserDTO userDTO) {
        User user = new User();
        user.setId(userDTO.getId());
        user.setEmail(userDTO.getEmail());
        user.setName(userDTO.getName());
        // Перетворення інших полів за потребою
        return user;
    }

}
