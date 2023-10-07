package com.planner.travel.utils;

import com.planner.travel.dto.RoleDTO;
import com.planner.travel.entity.Role;
import org.springframework.stereotype.Component;

@Component
public class RoleMapper {

    public RoleDTO RoleToDTO(Role role) {
        RoleDTO dto = new RoleDTO();
        dto.setId(role.getId());
        dto.setName(role.getName());
        // Перетворення інших полів за потребою
        return dto;
    }

    public Role toEntity(RoleDTO roleDTO) {
        Role role = new Role();
        role.setId(roleDTO.getId());
        role.setName(roleDTO.getName());

        // Перетворення інших полів за потребою
        return role;


    }
}