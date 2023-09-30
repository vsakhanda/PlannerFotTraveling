package com.planner.travel.controller;

import com.planner.travel.model.Trip;
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

    @GetMapping("/parameter/{tripId}")
    public ResponseEntity<Trip> getParameter(@PathVariable("tripId") int tripId) { //@PathVariable - вичитування назви з URL
        return ResponseEntity.ok(tservice.getById(tripId));
    }

    @GetMapping("/requestparameter")
    public ResponseEntity<Trip> getByRequestParam(@RequestParam("tripId") int tripId) { //@PathVariable - вичитування назви з URL
        return ResponseEntity.ok(tservice.getById(tripId));
    }

    @PostMapping("/requestBody")
    public ResponseEntity<Trip> postUser(@RequestBody Trip trip) { //@PathVariable - вичитування назви з URL
        return ResponseEntity.ok(tservice.add(trip));

    }
}
