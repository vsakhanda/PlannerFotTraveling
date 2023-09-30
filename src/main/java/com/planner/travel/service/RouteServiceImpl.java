package com.planner.travel.service;

import com.planner.travel.model.Route;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class RouteServiceImpl implements RouteService{


    private Map<Integer, Route> routes = new HashMap<>();

    // DAO layer 48.44
    @Override
    public Route getById(int id) {
        return routes.get(id);
    }

    @Override
    public Route add(Route route) {
        routes.put(route.getId(), route);
        return route;
    }

    @PostConstruct
    public void init() {
        Route route1 = Route.builder()
                .id(1)
                .name("route one")
                .build();
        Route route2 = Route.builder()
                .id(2)
                .name("route two")
                .build();
        routes.put(1, route1);
        routes.put(2, route2);
    }

}
