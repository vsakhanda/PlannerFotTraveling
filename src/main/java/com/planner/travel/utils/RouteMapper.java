package com.planner.travel.utils;

import com.planner.travel.dto.RouteDTO;
import com.planner.travel.entity.Route;
import org.springframework.stereotype.Component;

@Component
public class RouteMapper {


    public RouteDTO routeToDTO(Route route) {
        RouteDTO dto = new RouteDTO();
        dto.setId(route.getId());
        dto.setName(route.getName());
        dto.setDescription(route.getDescription());
        // Перетворення інших полів за потребою
        return dto;
    }

    public Route routeToEntity(RouteDTO routeDTO) {
        Route route = new Route();
        route.setId(routeDTO.getId());
        route.setName(routeDTO.getName());
        route.setAuthor(routeDTO.getAuthor());
        route.setDescription(routeDTO.getDescription());

        // Перетворення інших полів за потребою
        return route;

    }
}