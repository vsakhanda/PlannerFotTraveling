package com.planner.travel.utils;

import com.planner.travel.dto.RouteDTO;
import com.planner.travel.entity.Route;
import org.springframework.stereotype.Component;

@Component
public class RouteMapper {


    public RouteDTO toDTO(Route route) {
        RouteDTO dto = new RouteDTO();
        dto.setId(route.getId());
        dto.setName(route.getName());
        dto.setDescription(route.getDescription());
        dto.set_round_route(route.is_round_route());
        dto.set_private(route.is_private());
        //dto.setAuthor(route.getAuthor());
        // Перетворення інших полів за потребою
        return dto;
    }

    public Route toEntity(RouteDTO routeDTO) {
        Route route = new Route();
        route.setId(routeDTO.getId());
        route.setName(routeDTO.getName());
      //  route.setAuthor(routeDTO.getAuthor());
        route.setDescription(routeDTO.getDescription());
        route.set_round_route(routeDTO.is_round_route());
        route.set_private(routeDTO.is_private());

        // Перетворення інших полів за потребою
        return route;

    }
}