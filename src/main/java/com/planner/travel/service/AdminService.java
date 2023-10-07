package com.planner.travel.service;

import com.planner.travel.dto.AdminUserDTO;
import com.planner.travel.dto.RoleDTO;
import com.planner.travel.dto.UserDTO;

import java.util.List;
import java.util.Optional;

public interface AdminService {

    boolean deleteUserAdmin(int userId);

    AdminUserDTO updateUserRoles (int userId, AdminUserDTO adminUserDTO);
    Optional<AdminUserDTO> getUserRoles (int userId);

    RoleDTO createRole(RoleDTO roleDTO);

    List<AdminUserDTO> findAll();

}
