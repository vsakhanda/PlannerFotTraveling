package com.planner.travel.service;

import com.planner.travel.dto.PointDTO;

import java.util.List;
import java.util.Optional;

public interface PointService {


    PointDTO createPoint(PointDTO pointSTO);
    Optional<PointDTO> getPoint(int pointId);
    List<PointDTO> findAllPoints();
    PointDTO updatePoint(int userId, PointDTO pointDTO);
    boolean deletePoint(int pointId);
    Optional<PointDTO> getPointById(int pointId);


}
