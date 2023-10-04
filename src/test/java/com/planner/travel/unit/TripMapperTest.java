package com.planner.travel.unit;

import com.planner.travel.dto.TripDTO;
import com.planner.travel.entity.Trip;
import com.planner.travel.utils.TripMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TripMapperTest {

    private TripMapper tripMapper;

    @BeforeEach
    public void setUp() {
        tripMapper = new TripMapper();
    }

    @Test
    public void tripToDTO() {
        //Підготовка
        Trip trip = new Trip();
        trip.setId(1);
        trip.setName("Trip1");

        //Дія
        TripDTO dto = tripMapper.tripToDTO(trip);

        //Перевірка
        assertEquals(1L, dto.getId());
        assertEquals("Trip1", dto.getName());

    }

    @Test
    public void tripToEntity() {
        // Підготовка
        TripDTO dto = new TripDTO();
        dto.setId(1);
        dto.setName("Trip2");

        // Дія
        Trip trip = tripMapper.tripToEntity(dto);

        // Перевірка
        assertEquals(1L, trip.getId());
        assertEquals("Trip2", trip.getName());

    }

}
