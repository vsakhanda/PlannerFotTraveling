package com.planner.travel.controller;


import com.planner.travel.dto.AdminUserDTO;
import com.planner.travel.dto.RoleDTO;
import com.planner.travel.dto.UserDTO;
import com.planner.travel.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/admin")
public class AdminController {


    private final AdminService service;

    @Autowired
    public AdminController(AdminService service) {
        this.service = service;
    }

  //  @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/delete/{userId}")
    public ResponseEntity<?> delete(@PathVariable int userId) {
        boolean deleted = service.deleteUserAdmin(userId);
        if (deleted) {
            return ResponseEntity.ok().build(); // Відповідь зі статусом 200 OK, якщо користувача видалено.
        } else {
            return ResponseEntity.notFound().build(); // Відповідь зі статусом 404 Not Found, якщо користувача з таким ID не знайдено.
        }
    }


    // додавання ролей -  користувач- масив ролей
    @PatchMapping("/updateUser/{userId}")
    public ResponseEntity<AdminUserDTO> updateUser (@PathVariable int userId, @RequestBody AdminUserDTO adminUserDTO) { //@PathVariable - вичитування назви з URL
        AdminUserDTO updatedUserRoles = service.updateUserRoles(userId, adminUserDTO);
        if (updatedUserRoles != null) {
            return ResponseEntity.ok(updatedUserRoles);
        } else {
            return ResponseEntity.notFound().build(); // Відповідь зі статусом 404, якщо користувача з таким ID не знайдено.
        }
    }

    //    GET Отримання інформації про коритувача з усіма його ролями
    @GetMapping("/getUserRoles/{userId}")
    public ResponseEntity<Optional<AdminUserDTO>> getUser(@PathVariable("userId") int userId) { //@PathVariable - вичитування назви з URL
        return ResponseEntity.ok(service.getUserRoles(userId));
    }


    @PostMapping("/postRole")
    public ResponseEntity<RoleDTO> createRole (@RequestBody RoleDTO roleDTO) { //@PathVariable - вичитування назви з URL
        return ResponseEntity.ok(service.createRole(roleDTO));
    }

//
//    @GetMapping("/allUsers")
//    public ResponseEntity<List<UserDTO>> getAllUsers() { //@PathVariable - вичитування назви з URL
//        return ResponseEntity.ok(service.findAllUsers());
//    }

}
