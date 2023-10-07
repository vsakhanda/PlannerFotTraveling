package com.planner.travel.utils;

import com.planner.travel.dto.AdminUserDTO;
import com.planner.travel.entity.User;
import org.springframework.stereotype.Component;

@Component
public class AdminMapper {


    public AdminUserDTO toDTO(User user) {
        AdminUserDTO adminUserDTO = new AdminUserDTO();
        adminUserDTO.setId(user.getId());
        adminUserDTO.setEmail(user.getEmail());
        adminUserDTO.setName(user.getName());
        adminUserDTO.setSurname(user.getSurname());
        adminUserDTO.setPhone(user.getPhone());
        adminUserDTO.setCountry(user.getCountry());
        adminUserDTO.setCity(user.getCity());
        // Перетворення інших полів за потребою
        return adminUserDTO;
    }

    public User toEntity(AdminUserDTO adminUserDTO) {
        User users = new User();
        users.setId(adminUserDTO.getId());
        users.setEmail(adminUserDTO.getEmail());
        users.setName(adminUserDTO.getName());
        users.setSurname(adminUserDTO.getSurname());
        users.setPhone(adminUserDTO.getPhone());
        users.setCountry(adminUserDTO.getCountry());
        users.setCity(adminUserDTO.getCity());

        // Перетворення інших полів за потребою
        return users;
    }


}
