/*
package com.planner.travel.unit;

import com.planner.travel.dto.PointDTO;
import com.planner.travel.entity.Point;
import com.planner.travel.service.PointServiceImpl;
import com.planner.travel.utils.PointMapper;
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

public class PointServiceImplTest {

    @Mock
    private PointJpaRepository pointRepository;

    @Spy
    private PointMapper pointMapper;

    @InjectMocks
    private PointServiceImpl pointService;


    @BeforeEach
    public void setUp() {

        MockitoAnnotations.openMocks(this);
    }

    //  @Test
    public void testCreatePoint() {
        Point point = new Point();
        point.setId(1L);
        point.setName("point123");

        PointDTO pointDTO = new PointDTO();
        pointDTO.setId(1L);
        pointDTO.setName("point123");

        when(pointRepository.save(any())).thenReturn(point);

        PointDTO resultDTO = pointService.createPoint(pointDTO);

        verify(pointRepository, times(1)).save(any(Point.class));
        assertEquals(1L, resultDTO.getId());

        // За необхідності можна перевірити виклики методів на шпигуні
        verify(pointMapper, times(1)).poinytoEntity(pointDTO);
        verify(pointMapper, times(1)).toDTO(point);
    }

    @Test
    public void testGetPoint() {
        Point point = new Point();
        point.setId(1L);
        point.setName("Point2");

        PointDTO pointDTO = new PointDTO();
        point.setId(1L);
        point.setName("Point2");


        given(pointRepository.findById(1L)).willReturn(Optional.of(point));

        Optional<PointDTO> resultDTO = pointService.getPoint(1L);

        assertTrue(resultDTO.isPresent());
        assertEquals(1L, resultDTO.get().getId());

        // За необхідності можна перевірити виклики методів на шпигуні
        verify(pointMapper, times(1)).toDTO(point);
    }
}
}

*/
