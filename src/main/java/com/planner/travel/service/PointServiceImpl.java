package com.planner.travel.service;

import com.planner.travel.model.Point;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class PointServiceImpl implements PointService{


    private Map<Integer, Point> points = new HashMap<>();

    // DAO layer 48.44
    @Override
    public Point getById(int id) {
        return points.get(id);
    }

    @Override
    public Point add(Point point) {
        points.put(point.getId(), point);
        return point;
    }

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
    }
}
