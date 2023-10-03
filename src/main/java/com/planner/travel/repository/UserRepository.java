package com.planner.travel.repository;

import com.planner.travel.entity.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserRepository extends CrudRepository<User, Long> {

    List<User> findByNameContaining(String nameFragment);
}
