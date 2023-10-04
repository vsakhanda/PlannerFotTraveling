package com.planner.travel.controller;

import com.planner.travel.entity.Route;
import com.planner.travel.service.RouteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping ("/api/v1/routes")
public class RouteController {

    private final RouteService rservice;

    @Autowired
    public RouteController(RouteService rservice) {
        this.rservice = rservice;
    }

    // POST Додавання маршрутів. В тілі запиту передаємо модель з інформацією про користувача. Після додаваня користувача він повинен з'явитись в базі
    @PostMapping("/requestBody")
    public ResponseEntity<Route> postUser(@RequestBody Route route) { //@PathVariable - вичитування назви з URL
        return ResponseEntity.ok(rservice.add(route));
    }

    // GET Отримання інформації про точку за її ID
    @GetMapping("/requestparameter")
    public ResponseEntity<Route> getByRequestParam(@RequestParam("routeId") int routeId) { //@PathVariable - вичитування назви з URL
        return ResponseEntity.ok(rservice.getById(routeId));
    }

    // GET Отримання інформації про коритувача з описом інформації з URL
    @GetMapping("/parameter/{routeId}")
    public ResponseEntity<Route> getParameter(@PathVariable("routeId") int routeId) { //@PathVariable - вичитування назви з URL
        return ResponseEntity.ok(rservice.getById(routeId));
    }

    // PUT
    // Оновлення даних про маршрут

    // PATCH
    // Оновлення даних про точки маршруту


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
