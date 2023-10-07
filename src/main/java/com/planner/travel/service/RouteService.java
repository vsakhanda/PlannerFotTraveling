package com.planner.travel.service;


import com.planner.travel.dto.RouteDTO;

import java.util.List;
import java.util.Optional;

public interface RouteService {



    RouteDTO createRoute(RouteDTO routeSTO);
    Optional<RouteDTO> get(int routeId);
    List<RouteDTO> findAll();
    RouteDTO updateRoute(int routeId, RouteDTO routeDTO);
    boolean delete(int routeId);
    Optional<RouteDTO> getRouteById(int routeId);


}
