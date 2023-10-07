package com.planner.travel.controller;


import com.planner.travel.dto.UserDTO;
import com.planner.travel.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


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
    public ResponseEntity<UserDTO> createUser (@RequestBody UserDTO userDTO) { //@PathVariable - вичитування назви з URL
        return ResponseEntity.ok(service.createUser(userDTO));
    }

 //    GET Отримання інформації про коритувача
    @GetMapping("/getDirectUser/{userId}")
    public ResponseEntity<Optional<UserDTO>> getUser(@PathVariable("userId") int userId) { //@PathVariable - вичитування назви з URL
        return ResponseEntity.ok(service.getUser(userId));
    }

    // GET Отримання інформації про коритувача з описом інформації з URL
    @GetMapping("/getUser")
    public ResponseEntity<Optional<UserDTO>> getUserByRequestParam(@RequestParam("userId") int userId) { //@PathVariable - вичитування назви з URL
        return ResponseEntity.ok(service.getUser(userId));
    }

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/allUsers")
    public ResponseEntity<List<UserDTO>> getAllUsers() { //@PathVariable - вичитування назви з URL
        return ResponseEntity.ok(service.findAllUsers());
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PatchMapping("/updateUser/{userId}")
    public ResponseEntity<UserDTO> updateUser (@PathVariable int userId, @RequestBody UserDTO userDTO) { //@PathVariable - вичитування назви з URL
        UserDTO updatedUser = service.updateUser(userId, userDTO);
        if (updatedUser != null) {
            return ResponseEntity.ok(updatedUser);
        } else {
            return ResponseEntity.notFound().build(); // Відповідь зі статусом 404, якщо користувача з таким ID не знайдено.
        }
    }

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/delete/{userId}")
    public ResponseEntity<?> delete(@PathVariable int userId) {
        boolean deleted = service.deleteUser(userId);
        if (deleted) {
            return ResponseEntity.ok().build(); // Відповідь зі статусом 200 OK, якщо користувача видалено.
        } else {
            return ResponseEntity.notFound().build(); // Відповідь зі статусом 404 Not Found, якщо користувача з таким ID не знайдено.
        }
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
