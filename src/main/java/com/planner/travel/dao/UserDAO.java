package com.planner.travel.dao;

/*
JpaRepository: Цей інтерфейс наслідується від CrudRepository
та включає в себе додаткові JPA-специфічні операції, такі як збереження в пакетному режимі
(flush(), saveAndFlush()) і пагінація (findAll(Pageable pageable)).

JpaRepository надає розширений набір операцій, які корисні для JPA, такі як flush(), deleteInBatch(), getOne(), findAll(Sort sort) та ін.

JpaRepository надає методи, такі як saveAll(), flush(), deleteInBatch()
 */

import com.planner.travel.entity.User;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

@Primary
public interface UserDAO extends JpaRepository<User, Long> {


    User findById(Integer id);

    User save(User user);

    List<User> findByNameContaining(String nameFragment);

    List<User> findByName(String name);

    @Query("SELECT u FROM User u WHERE u.email = ?1")
    Optional<User> findByEmail(String email);


    boolean existsById(int id);
}
