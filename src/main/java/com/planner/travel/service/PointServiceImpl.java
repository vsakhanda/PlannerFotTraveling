package com.planner.travel.service;

import com.planner.travel.customException.CustomException;
import com.planner.travel.dto.PointDTO;
import com.planner.travel.entity.Point;
import com.planner.travel.repository.PointRepo;
import com.planner.travel.utils.PointMapper;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PointServiceImpl implements PointService{

    private final PointRepo pointRepo;
    private final PointMapper pointMapper;

    private final Map<Integer, Point> points = new HashMap<>();

    public PointServiceImpl(PointRepo pointRepo, PointMapper pointMapper) {
        this.pointRepo = pointRepo;
        this.pointMapper = pointMapper;
    }

    @Transactional
    @Override
    public PointDTO createPoint(PointDTO pointDTO) {
        Point point = pointMapper.toEntity(pointDTO);
        point = pointRepo.save(point);
        return pointMapper.toDTO(point);
    }

    @Transactional(readOnly = true)
    @Override
    public Optional<PointDTO> getPoint(int id) {
        return pointRepo.findById(id).map(pointMapper::toDTO);
    }

    @Override
    public List<PointDTO> findAllPoints() {
        return pointRepo.findAll()
                .stream()
                .map(pointMapper::toDTO)
                .collect(Collectors.toList());
    }


    @Override
    public Optional<PointDTO> getPointById(int pointId) {
        return Optional.empty();
    }

    @Override
    public boolean deletePoint(int pointId) {
        pointRepo.deleteById(pointId);
        throw new CustomException("deleted wrong should be rollback", 500);
    }

    @Transactional
    @Override
    public PointDTO updatePoint(int pointId, PointDTO pointDTO) {
        if (pointRepo.existsById(pointId)) {
            Point point = pointMapper.toEntity(pointDTO);
            point.setId(pointId);
            point = pointRepo.save(point);
            return pointMapper.toDTO(point);
        }
        // Тут можна додати обробку винятків, якщо елемент не знайдено.
        return null;
    }

/*
  @PostConstruct
    public void init() {
        Point point1 = Point.builder()
                .id(1)
                .name("point A")
                .build();
        Point point2 = Point.builder()
                .id(2)
                .name("point B")
                .build();
        points.put(1, point1);
        points.put(2, point2);
    }*/
}
