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

    // POST Додавання користувача. В тілі запиту передаємо модель з інформацією про користувача. Після додаваня користувача він повинен з'явитись в базі

    @PostMapping("/requestBody")
    public ResponseEntity<User> postUser(@RequestBody User user) { //@PathVariable - вичитування назви з URL
        return ResponseEntity.ok(service.add(user));
    }

    // GET Отримання інформації про коритувача
    @GetMapping("/parameter/{userId}")
    public ResponseEntity<User> getParameter(@PathVariable("userId") int userId) { //@PathVariable - вичитування назви з URL
        return ResponseEntity.ok(service.getById(userId));
    }

    // GET Отримання інформації про коритувача з описом інформації з URL
    @GetMapping("/requestparameter")
    public ResponseEntity<User> getByRequestParam(@RequestParam("userId") int userId) { //@PathVariable - вичитування назви з URL
        return ResponseEntity.ok(service.getById(userId));
    }

    // PATCH Оновлення інформації про користувача
    // Оноалення даємо лише АДМІНУ
    // @PreAuthorize("hasRole('ADMIN')")

    // DELETE - Видалення коритсувача за ID (встановлення відмітки про видалення)
    // Оноалення даємо лише АДМІНУ
    // @PreAuthorize("hasRole('ADMIN')")

    // FindALL  - отримання інформації про всіх користувачів
    // Оноалення даємо лише АДМІНУ
    // @PreAuthorize("hasRole('ADMIN')")


    // ***********
    // Тестові методи для перевірки рольової моделі
    // Метод, що віддає інформамію лише Адміну
    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/admin")
    public String getAdminInfo() {
        return "Hello admin";
    }

    // Метод, що віддає інформамію для користувача
    @PreAuthorize("hasRole('USER')")
    @GetMapping("/info")
    public String getUser() {
        return "Hello user";
    }

    // Метод, що віддає інформамію всім.
    @GetMapping("/public")
    public String publicinfo() {
        return "Public info - hello java world!";
    }

    // ************




}
