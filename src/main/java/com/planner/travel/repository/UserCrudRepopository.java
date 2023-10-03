package com.planner.travel.repository;

/*
 CrudRepository Цей інтерфейс надає базовий набір операцій CRUD (створення, читання, оновлення, видалення).
 */
import com.planner.travel.entity.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface UserCrudRepopository extends CrudRepository<User, Long> {
    List<User> findByName(String name);

    @Query("SELECT u FROM User u WHERE u.email = ?1")
    Optional<User> findByEmail(String email);



}
