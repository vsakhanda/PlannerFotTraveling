package com.planner.travel.utils;

import com.planner.travel.dto.UserDTO;
import com.planner.travel.entity.User;
import org.springframework.stereotype.Component;

// Отримуємо всю інформацію про користувача

@Component
public class UserMapper {

    public UserDTO toDTO(User user)
//       return UserDTO.builder()
//               .id(user.getId())
//               .name(name.getName())
//               .country()
//               .phone()
//               .email()
//               .surname()
//               .city()
//               .build();
//    }

    {
        UserDTO userDTO = new UserDTO();
        userDTO.setId(user.getId());
        userDTO.setEmail(user.getEmail());
        userDTO.setName(user.getName());
        userDTO.setSurname(user.getSurname());
        userDTO.setPhone(user.getPhone());
        userDTO.setCountry(user.getCountry());
        userDTO.setCity(user.getCity());
        // Перетворення інших полів за потребою
        return userDTO;
    }

    public User toEntity(UserDTO userDTO) {
        User users = new User();
        users.setId(userDTO.getId());
        users.setEmail(userDTO.getEmail());
        users.setName(userDTO.getName());
        users.setSurname(userDTO.getSurname());
        users.setPhone(userDTO.getPhone());
        users.setCountry(userDTO.getCountry());
        users.setCity(userDTO.getCity());

        // Перетворення інших полів за потребою
        return users;
    }

}
