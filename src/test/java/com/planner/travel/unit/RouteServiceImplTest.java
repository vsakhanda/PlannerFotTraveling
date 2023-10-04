/*
package com.planner.travel.unit;

import com.planner.travel.dto.RouteDTO;
import com.planner.travel.entity.Route;
import com.planner.travel.service.RouteServiceImpl;
import com.planner.travel.utils.RouteMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.*;

public class RouteServiceImplTest {


   @Mock
  private RouteJpaRepository routeRepository;

    @Spy
    private RouteMapper routeMapper;

    @InjectMocks
    private RouteServiceImpl routeService;


    @BeforeEach
    public void setUp() {

        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testCreateRoute() {
        Route route = new Route();
        route.setId(1L);
        route.setName("route123");

        RouteDTO routeDTO = new RouteDTO();
        routeDTO.setId(1L);
        routeDTO.setName("route123");

        when(routeRepository.save(any())).thenReturn(route);

        RouteDTO resultDTO = routeService.createRoute(routeDTO);

        verify(routeRepository, times(1)).save(any(Route.class));
        assertEquals(1L, resultDTO.getId());

        // За необхідності можна перевірити виклики методів на шпигуні
        verify(routeMapper, times(1)).poinytoEntity(routeDTO);
        verify(routeMapper, times(1)).toDTO(route);
    }

    @Test
    public void testGetRoute() {
        Route route = new Route();
        route.setId(1L);
        route.setName("Point2");

        RouteDTO routeDTO = new RouteDTO();
        route.setId(1L);
        route.setName("Point2");


        given(routeRepository.findById(1L)).willReturn(Optional.of(route));

        Optional<routeDTO> resultDTO = routeService.getRoute(1L);

        assertTrue(resultDTO.isPresent());
        assertEquals(1L, resultDTO.get().getId());

        // За необхідності можна перевірити виклики методів на шпигуні
        verify(routeMapper, times(1)).toDTO(route);
    }
}


}
*/
