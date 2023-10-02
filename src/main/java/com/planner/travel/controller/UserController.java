package com.planner.travel.controller;

import com.planner.travel.entity.User;
import com.planner.travel.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping ("/api/v1/users")
public class UserController {


    private final UserService service;

    @Autowired
    public UserController(UserService service) {
        this.service = service;
    }

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/admin")
    public String getAdminInfo() {
        return "Hello admin";
    }

    @PreAuthorize("hasRole('USER')")
    @GetMapping("/info")
    public String getUser() {
        return "Hello user";
    }

    @GetMapping("/public")
    public String publicinfo() {
        return "Public info - hello java world!";
    }

    @GetMapping("/parameter/{userId}")
    public ResponseEntity<User> getParameter(@PathVariable("userId") int userId) { //@PathVariable - вичитування назви з URL
        return ResponseEntity.ok(service.getById(userId));
    }

    @GetMapping("/requestparameter")
    public ResponseEntity<User> getByRequestParam(@RequestParam("userId") int userId) { //@PathVariable - вичитування назви з URL
        return ResponseEntity.ok(service.getById(userId));
    }

    @PostMapping("/requestBody")
    public ResponseEntity<User> postUser(@RequestBody User user) { //@PathVariable - вичитування назви з URL
        return ResponseEntity.ok(service.add(user));

    }
}
