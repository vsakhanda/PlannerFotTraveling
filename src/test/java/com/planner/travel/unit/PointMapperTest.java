package com.planner.travel.unit;

import com.planner.travel.dto.PointDTO;
import com.planner.travel.entity.Point;
import com.planner.travel.utils.PointMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PointMapperTest {


    private PointMapper pointMapper;

    @BeforeEach
    public void setUp() {
        pointMapper = new PointMapper();
    }

    @Test
    public void pointToDTO() {
        //Підготовка
        Point point = new Point();
        point.setId(1);
        point.setName("Point1");

        //Дія
        PointDTO dto = pointMapper.toDTO(point);

        //Перевірка
        assertEquals(1, dto.getId());
        assertEquals("Point1", dto.getName());


    }

    @Test
    public void tripToEntity() {
        // Підготовка
        PointDTO dto = new PointDTO();
        dto.setId(1);
        dto.setName("Point2");

        // Дія
        Point point = pointMapper.toEntity(dto);

        // Перевірка
        assertEquals(1, point.getId());
        assertEquals("Point2", point.getName());

    }

}
