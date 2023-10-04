package com.planner.travel.unit;

import com.planner.travel.dto.RouteDTO;
import com.planner.travel.entity.Route;
import com.planner.travel.utils.RouteMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RouteMapperTest {


    private RouteMapper routeMapper;

    @BeforeEach
    public void setUp() {
        routeMapper = new RouteMapper();
    }

    @Test
    public void tripToDTO() {
        //Підготовка
        Route route = new Route();
        route.setId(1);
        route.setName("Route1");

        //Дія
        RouteDTO dto = routeMapper.routeToDTO(route);

        //Перевірка
        assertEquals(1, dto.getId());
        assertEquals("Route1", dto.getName());


    }

    @Test
    public void tripToEntity() {
        // Підготовка
        RouteDTO dto = new RouteDTO();
        dto.setId(1);
        dto.setName("Route2");

        // Дія
        Route trip = routeMapper.routeToEntity(dto);

        // Перевірка
        assertEquals(1, trip.getId());
        assertEquals("Route2", trip.getName());

    }

}
