package com.planner.travel.utils;


import com.planner.travel.dto.PointDTO;
import com.planner.travel.entity.Point;
import org.springframework.stereotype.Component;

@Component
public class PointMapper {


    public PointDTO toDTO(Point point) {
        PointDTO dto = new PointDTO();
        dto.setId(point.getId());
        dto.setName(point.getName());
        dto.setDescription(point.getDescription());
        dto.setLongitude(point.getLongitude());
        dto.setLatitude(point.getLongitude());
        dto.setLink(point.getLink());
        dto.setDistrict(point.getDistrict());
        dto.setPhone_number(point.getPhone_number());
        dto.setPoint_adress(point.getPoint_adress());
        dto.setRegions(point.getRegions());
        // Перетворення інших полів за потребою
        return dto;
    }

    public Point toEntity(PointDTO pointDTO) {
        Point point = new Point();
        point.setId(pointDTO.getId());
        point.setName(pointDTO.getName());
        point.setDescription(pointDTO.getDescription());
        point.setLongitude(pointDTO.getLongitude());
        point.setLatitude(pointDTO.getLatitude());
        point.setLink(pointDTO.getLink());
        point.setDistrict(pointDTO.getDistrict());
        point.setPhone_number(pointDTO.getPhone_number());
        point.setPoint_adress(pointDTO.getPoint_adress());
        point.setRegions(pointDTO.getRegions());

        // Перетворення інших полів за потребою
        return point;

    }

}
