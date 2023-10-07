package com.planner.travel.repository;

import com.planner.travel.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepo extends JpaRepository<Role, Integer> {

    Optional<Role> findRoleById (int Id);
}
