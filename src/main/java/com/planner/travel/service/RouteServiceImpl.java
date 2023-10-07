package com.planner.travel.service;

import com.planner.travel.customException.CustomException;
import com.planner.travel.dto.RouteDTO;
import com.planner.travel.entity.Route;
import com.planner.travel.repository.RouteRepo;
import com.planner.travel.utils.RouteMapper;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class RouteServiceImpl implements RouteService{


    private final RouteRepo routeRepo;
    private final RouteMapper routeMapper;

    private final Map<Integer, Route> routes = new HashMap<>();

    public RouteServiceImpl(RouteRepo routeRepo, RouteMapper routeMapper) {
        this.routeRepo = routeRepo;
        this.routeMapper = routeMapper;
    }

    @Transactional
    @Override
    public RouteDTO createRoute(RouteDTO routeDTO) {
        Route point = routeMapper.toEntity(routeDTO);
        point = routeRepo.save(point);
        return routeMapper.toDTO(point);
    }

    @Transactional(readOnly = true)
    @Override
    public Optional<RouteDTO> get(int id) {
        return routeRepo.findById(id).map(routeMapper::toDTO);
    }

    @Override
    public List<RouteDTO> findAll() {
        return routeRepo.findAll()
                .stream()
                .map(routeMapper::toDTO)
                .collect(Collectors.toList());
    }


    @Override
    public Optional<RouteDTO> getRouteById(int Id) {
        return Optional.empty();
    }

    @Override
    public boolean delete(int routeId) {
        routeRepo.deleteById(routeId);
        throw new CustomException("deleted wrong should be rollback", 500);
    }

    @Transactional
    @Override
    public RouteDTO updateRoute(int routeId, RouteDTO routeDTO) {
        if (routeRepo.existsById(routeId)) {
            Route route = routeMapper.toEntity(routeDTO);
            route.setId(routeId);
            route = routeRepo.save(route);
            return routeMapper.toDTO(route);
        }
        // Тут можна додати обробку винятків, якщо елемент не знайдено.
        return null;
    }
/*
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
    }*/

}
