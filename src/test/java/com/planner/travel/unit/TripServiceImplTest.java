/*
package com.planner.travel.unit;


import com.planner.travel.dto.TripDTO;
import com.planner.travel.entity.Trip;
import com.planner.travel.service.TripServiceImpl;
import com.planner.travel.utils.TripMapper;
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

public class TripServiceImplTest {


    @Mock
    private TripJpaRepository tripRepository;

    @Spy
    private TripMapper tripMapper;

    @InjectMocks
    private TripServiceImpl tripService;


    @BeforeEach
    public void setUp() {

        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testCreateTrip() {
        Trip trip = new Trip();
        trip.setId(1L);
        trip.setName("Trip111");

        TripDTO tripDTO = new TripDTO();
        tripDTO.setId(1L);
        tripDTO.setName("Trip111");

        when(tripRepository.save(any())).thenReturn(trip);

        TripDTO resultDTO = tripService.createTrip(tripDTO);

        verify(tripRepository, times(1)).save(any(Trip.class));
        assertEquals(1L, resultDTO.getId());

        // За необхідності можна перевірити виклики методів на шпигуні
        verify(tripMapper, times(1)).tripToEntity(tripDTO);
        verify(tripMapper, times(1)).tripToDTO(trip);
    }

    @Test
    public void testGetTrip() {
        Trip trip = new Trip();
        trip.setId(1L);
        trip.setName("Trip22");

        TripDTO tripDTO = new TripDTO();
        tripDTO.setId(1L);
        tripDTO.setName("Trip22");


        given(tripRepository.findById(1L)).willReturn(Optional.of(trip));

        Optional<tripDTO> resultDTO = tripService.getTrip(1L);

        assertTrue(resultDTO.isPresent());
        assertEquals(1L, resultDTO.get().getId());

        // За необхідності можна перевірити виклики методів на шпигуні
        verify(tripMapper, times(1)).toDTO(trip);
    }
}
*/
