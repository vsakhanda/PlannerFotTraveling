package com.planner.travel.controller;

import com.planner.travel.dto.PointDTO;
import com.planner.travel.service.PointService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/api/v1/points")
public class PointController {

    private final PointService service;
    
    @Autowired
    public PointController(PointService pservice) {
            this.service = pservice;
        }

        // POST Додавання точки. В тілі запиту передаємо модель з інформацією про користувача. Після додаваня користувача він повинен з'явитись в базі

    @PostMapping("/requestBody")
    public ResponseEntity<PointDTO> createPoint (@RequestBody PointDTO pointDTO) { //@PathVariable - вичитування назви з URL
        return ResponseEntity.ok(service.createPoint(pointDTO));
    }

    //    GET Отримання інформації про коритувача
    @GetMapping("/get/{Id}")
    public ResponseEntity<Optional<PointDTO>> getPoint(@PathVariable("Id") int Id) { //@PathVariable - вичитування назви з URL
        return ResponseEntity.ok(service.getPoint(Id));
    }

    // GET Отримання інформації про коритувача з описом інформації з URL
    @GetMapping("/getPoint")
    public ResponseEntity<Optional<PointDTO>> getPointByRequestParam(@RequestParam("Id") int Id) { //@PathVariable - вичитування назви з URL
        return ResponseEntity.ok(service.getPoint(Id));
    }


    @GetMapping("/all")
    public ResponseEntity<List<PointDTO>> getAllPoints() { //@PathVariable - вичитування назви з URL
        return ResponseEntity.ok(service.findAllPoints());
    }

    @PatchMapping("/update/{Id}")
    public ResponseEntity<PointDTO> updatePoint (@PathVariable int Id, @RequestBody PointDTO pointDTO) { //@PathVariable - вичитування назви з URL
        PointDTO updatedUser = service.updatePoint(Id, pointDTO);
        if (updatedUser != null) {
            return ResponseEntity.ok(updatedUser);
        } else {
            return ResponseEntity.notFound().build(); // Відповідь зі статусом 404, якщо користувача з таким ID не знайдено.
        }
    }

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/delete/{Id}")
    public ResponseEntity<?> delete(@PathVariable int Id) {
        boolean deleted = service.deletePoint(Id);
        if (deleted) {
            return ResponseEntity.ok().build(); // Відповідь зі статусом 200 OK, якщо користувача видалено.
        } else {
            return ResponseEntity.notFound().build(); // Відповідь зі статусом 404 Not Found, якщо користувача з таким ID не знайдено.
        }
    }


    // PATCH Оновлення інформації про точку
        // Оноалення даємо лише USER
        // @PreAuthorize("hasRole('ADMIN')")

        // DELETE - Видалення точки за ID (встановлення відмітки про видалення)
        // Оноалення даємо лише АДМІНУ
        // @PreAuthorize("hasRole('ADMIN')")

        // FindALL  - отримання інформації про всіх користувачів
        // Оноалення даємо лише АДМІНУ
        // @PreAuthorize("hasRole('ADMIN')")

        // findByNameContaining  - отримання інформації про всіх користувачів

        // ***********
        // Тестові методи для перевірки рольової моделі
        @GetMapping("/admin")
        public String getAdminInfo() {
            return "Hello admin";
        }

        @GetMapping("/info")
        public String getUser() {
            return "Hello user";
        }

        @GetMapping("/public")
        public String publicinfo() {
            return "Public info - hello java world!";
        }


}
