package com.planner.travel.repository;

/*
JpaRepository: Цей інтерфейс наслідується від CrudRepository
та включає в себе додаткові JPA-специфічні операції, такі як збереження в пакетному режимі
(flush(), saveAndFlush()) і пагінація (findAll(Pageable pageable)).

JpaRepository надає розширений набір операцій, які корисні для JPA, такі як flush(), deleteInBatch(), getOne(), findAll(Sort sort) та ін.

JpaRepository надає методи, такі як saveAll(), flush(), deleteInBatch()
 */

import com.planner.travel.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface UserJpaRepository extends JpaRepository<User, Long> {

    Optional<User> findByEmail(String email);
}
