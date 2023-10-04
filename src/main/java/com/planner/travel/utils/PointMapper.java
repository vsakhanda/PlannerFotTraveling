package com.planner.travel.utils;


import com.planner.travel.dto.PointDTO;
import com.planner.travel.entity.Point;
import org.springframework.stereotype.Component;

@Component
public class PointMapper {


    public PointDTO pointToDTO(Point point) {
        PointDTO dto = new PointDTO();
        dto.setId(point.getId());
        dto.setName(point.getName());
        dto.setDescription(point.getDescription());
        dto.setLongitude(point.getLongitude());
        dto.setLatitude(point.getLongitude());
        // Перетворення інших полів за потребою
        return dto;
    }

    public Point pointToEntity(PointDTO pointDTO) {
        Point point = new Point();
        point.setId(pointDTO.getId());
        point.setName(pointDTO.getName());
        point.setDescription(pointDTO.getDescription());
        point.setLongitude(pointDTO.getLongitude());
        point.setLatitude(pointDTO.getLatitude());

        // Перетворення інших полів за потребою
        return point;

    }

}
