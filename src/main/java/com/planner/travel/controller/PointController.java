package com.planner.travel.controller;

import com.planner.travel.model.Point;
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

        @GetMapping("/parameter/{pointId}")
        public ResponseEntity<Point> getParameter(@PathVariable("pointId") int pointId) { //@PathVariable - вичитування назви з URL
            return ResponseEntity.ok(pservice.getById(pointId));
        }

        @GetMapping("/requestparameter")
        public ResponseEntity<Point> getByRequestParam(@RequestParam("pointId") int pointId) { //@PathVariable - вичитування назви з URL
            return ResponseEntity.ok(pservice.getById(pointId));
        }

        @PostMapping("/requestBody")
        public ResponseEntity<Point> postUser(@RequestBody Point point) { //@PathVariable - вичитування назви з URL
            return ResponseEntity.ok(pservice.add(point));

        }

}
