package com.planner.travel.controller;

import com.planner.travel.dto.RouteDTO;
import com.planner.travel.service.RouteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping ("/api/v1/routes")
public class RouteController {

    private final RouteService service;

    @Autowired
    public RouteController(RouteService rservice) {
        this.service = rservice;
    }

    // POST Додавання маршрутів. В тілі запиту передаємо модель з інформацією про користувача. Після додаваня користувача він повинен з'явитись в базі

    @PostMapping("/requestBody")
    public ResponseEntity<RouteDTO> createRoute(@RequestBody RouteDTO routeDTO) { //@PathVariable - вичитування назви з URL
        return ResponseEntity.ok(service.createRoute(routeDTO));
    }

    //    GET Отримання інформації про коритувача
    @GetMapping("/get/{Id}")
    public ResponseEntity<Optional<RouteDTO>> getPoint(@PathVariable("Id") int Id) { //@PathVariable - вичитування назви з URL
        return ResponseEntity.ok(service.get(Id));
    }

    // GET Отримання інформації про коритувача з описом інформації з URL
    @GetMapping("/getPoint")
    public ResponseEntity<Optional<RouteDTO>> getPointByRequestParam(@RequestParam("Id") int Id) { //@PathVariable - вичитування назви з URL
        return ResponseEntity.ok(service.get(Id));
    }


    @GetMapping("/all")
    public ResponseEntity<List<RouteDTO>> getAllRoutes() { //@PathVariable - вичитування назви з URL
        return ResponseEntity.ok(service.findAll());
    }

    @PatchMapping("/update/{Id}")
    public ResponseEntity<RouteDTO> updateRoute (@PathVariable int Id, @RequestBody RouteDTO routeDTO) { //@PathVariable - вичитування назви з URL
        RouteDTO updatedRoute = service.updateRoute(Id, routeDTO);
        if (updatedRoute != null) {
            return ResponseEntity.ok(updatedRoute);
        } else {
            return ResponseEntity.notFound().build(); // Відповідь зі статусом 404, якщо користувача з таким ID не знайдено.
        }
    }

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/delete/{Id}")
    public ResponseEntity<?> delete(@PathVariable int Id) {
        boolean deleted = service.delete(Id);
        if (deleted) {
            return ResponseEntity.ok().build(); // Відповідь зі статусом 200 OK, якщо користувача видалено.
        } else {
            return ResponseEntity.notFound().build(); // Відповідь зі статусом 404 Not Found, якщо користувача з таким ID не знайдено.
        }
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
