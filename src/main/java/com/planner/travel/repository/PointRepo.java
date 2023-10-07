package com.planner.travel.repository;

import com.planner.travel.entity.Point;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PointRepo extends JpaRepository<Point, Integer> {

    Optional<Point> findPointById (int Id);

}
