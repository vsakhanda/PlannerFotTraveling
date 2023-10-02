package com.planner.travel.service;

import com.planner.travel.entity.User;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
@Service
public class UserServiceImpl implements UserService{


    private final Map<Integer, User> users = new HashMap<>();

    // DAO layer 48.44
    @Override
    public User getById(int id) {
        return users.get(id);
    }

    @Override
    public User add(User user) {
        users.put(Math.toIntExact(user.getId()), user);
        return user;
    }

    @PostConstruct
    public void init() {
        User sergij = User.builder()
                .id(1L)
                .name("Serhij")
                .build();
        User vlad = User.builder()
                .id(2L)
                .name("Vlad")
                .build();
        users.put(1, sergij);
        users.put(2, vlad);
    }

}
