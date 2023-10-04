package com.planner.travel.controller;

import com.planner.travel.entity.Trip;
import com.planner.travel.service.TripService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/trips")
public class TripController {


    private final TripService tservice;

    @Autowired
    public TripController(TripService tservice) {
        this.tservice = tservice;
    }

    // POST Додавання подорожей. В тілі запиту передаємо модель з інформацією про користувача. Після додаваня користувача він повинен з'явитись в базі
    @PostMapping("/requestBody")
    public ResponseEntity<Trip> postUser(@RequestBody Trip trip) { //@PathVariable - вичитування назви з URL
        return ResponseEntity.ok(tservice.add(trip));
    }

    // GET Отримання інформації про точку за її ID
    @GetMapping("/parameter/{tripId}")
    public ResponseEntity<Trip> getParameter(@PathVariable("tripId") int tripId) { //@PathVariable - вичитування назви з URL
        return ResponseEntity.ok(tservice.getById(tripId));
    }


    // GET Отримання інформації про точку за її ID
    @GetMapping("/requestparameter")
    public ResponseEntity<Trip> getByRequestParam(@RequestParam("tripId") int tripId) { //@PathVariable - вичитування назви з URL
        return ResponseEntity.ok(tservice.getById(tripId));
    }

    // PUT Оновлення даних про подорож та стан подорожі

    // PATCH Оновлення даних про точки подорожі

    // PATCH Оновлення даних про попотчиків

    // PATCH



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
