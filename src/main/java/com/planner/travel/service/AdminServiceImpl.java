package com.planner.travel.service;

import com.planner.travel.customException.CustomException;
import com.planner.travel.dto.AdminUserDTO;
import com.planner.travel.dto.RoleDTO;
import com.planner.travel.dto.UserDTO;
import com.planner.travel.entity.Role;
import com.planner.travel.entity.User;
import com.planner.travel.repository.RoleRepo;
import com.planner.travel.repository.UserRepo;
import com.planner.travel.utils.AdminMapper;
import com.planner.travel.utils.RoleMapper;
import com.planner.travel.utils.UserMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class AdminServiceImpl implements AdminService {


    private final UserRepo userRepo;
    private final RoleRepo roleRepo;
    private final AdminMapper adminMapper;
    private final RoleMapper roleMapper;


    public AdminServiceImpl(UserRepo userRepo, AdminMapper adminMapper, RoleRepo roleRepo, RoleMapper  roleMapper) {
        this.userRepo = userRepo;
        this.roleRepo = roleRepo;
        this.adminMapper = adminMapper;
        this.roleMapper = roleMapper;


    }

    @Override
    public boolean deleteUserAdmin(int userId) {
        userRepo.deleteById(userId);
        throw new CustomException("deleted wrong should be rollback", 500);
    }

    @Override
    public Optional<AdminUserDTO> getUserRoles(int userId) {
        return Optional.empty();
    }

    @Transactional
    @Override
    public AdminUserDTO updateUserRoles(int userId, AdminUserDTO adminUserDTO) {
        if (userRepo.existsById(userId)) {
            User user = adminMapper.toEntity(adminUserDTO);
            user.setId(userId);
            user = userRepo.save(user);
            return adminMapper.toDTO(user);
        }
        // Тут можна додати обробку винятків, якщо елемент не знайдено.
        return null;
    }

    @Transactional
    @Override
    public RoleDTO createRole(RoleDTO roleDTO) {
        Role role = roleMapper.toEntity(roleDTO);
        role = roleRepo.save(role);
        return roleMapper.toDTO(role);
    }


}

