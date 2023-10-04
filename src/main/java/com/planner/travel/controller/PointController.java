package com.planner.travel.controller;

import com.planner.travel.entity.Point;
import com.planner.travel.service.PointService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


    @RestController
    @RequestMapping("/api/v1/points")
    public class PointController {

        private final PointService pservice;

        @Autowired
        public PointController(PointService pservice) {
            this.pservice = pservice;
        }

        // POST Додавання точки. В тілі запиту передаємо модель з інформацією про користувача. Після додаваня користувача він повинен з'явитись в базі
        @PostMapping("/requestBody")
        public ResponseEntity<Point> postUser(@RequestBody Point point) { //@PathVariable - вичитування назви з URL
            return ResponseEntity.ok(pservice.add(point));

        }

        // GET Отримання інформації про точку за її ID
        @GetMapping("/parameter/{pointId}")
        public ResponseEntity<Point> getParameter(@PathVariable("pointId") int pointId) { //@PathVariable - вичитування назви з URL
            return ResponseEntity.ok(pservice.getById(pointId));
        }
        // GET Отримання інформації про коритувача з описом інформації з URL
        @GetMapping("/requestparameter")
        public ResponseEntity<Point> getByRequestParam(@RequestParam("pointId") int pointId) { //@PathVariable - вичитування назви з URL
            return ResponseEntity.ok(pservice.getById(pointId));
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
