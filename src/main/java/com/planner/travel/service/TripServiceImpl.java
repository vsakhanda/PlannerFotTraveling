package com.planner.travel.service;

import com.planner.travel.customException.CustomException;
import com.planner.travel.dto.TripDTO;
import com.planner.travel.entity.Trip;
import com.planner.travel.repository.TripRepo;
import com.planner.travel.utils.TripMapper;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TripServiceImpl implements TripService{

    private final TripRepo tripRepo;
    private final TripMapper tripMapper;

    private final Map<Integer, Trip> trips = new HashMap<>();

    public TripServiceImpl(TripRepo tripRepo, TripMapper tripMapper) {
        this.tripRepo = tripRepo;
        this.tripMapper = tripMapper;
    }

    @Transactional
    @Override
    public TripDTO createTrip(TripDTO tripDTO) {
        Trip point = tripMapper.toEntity(tripDTO);
        point = tripRepo.save(point);
        return tripMapper.toDTO(point);
    }

    @Transactional(readOnly = true)
    @Override
    public Optional<TripDTO> get(int id) {
        return tripRepo.findById(id).map(tripMapper::toDTO);
    }

    @Override
    public List<TripDTO> findAll() {
        return tripRepo.findAll()
                .stream()
                .map(tripMapper::toDTO)
                .collect(Collectors.toList());
    }


    @Override
    public Optional<TripDTO> getTripById(int Id) {
        return Optional.empty();
    }

    @Override
    public boolean delete(int tripId) {
        tripRepo.deleteById(tripId);
        throw new CustomException("deleted wrong should be rollback", 500);
    }

    @Transactional
    @Override
    public TripDTO updateTrip(int tripId, TripDTO tripDTO) {
        if (tripRepo.existsById(tripId)) {
            Trip trip = tripMapper.toEntity(tripDTO);
            trip.setId(tripId);
            trip = tripRepo.save(trip);
            return tripMapper.toDTO(trip);
        }
        // Тут можна додати обробку винятків, якщо елемент не знайдено.
        return null;
    }
/*

        @PostConstruct
        public void init() {
            Trip vacation1 = Trip.builder()
                    .id(1)
                    .name("Maldivs")
                    .build();
            Trip vacation2 = Trip.builder()
                    .id(2)
                    .name("Sri-Lanka")
                    .build();
            trips.put(1, vacation1);
            trips.put(2, vacation2);
        }
*/

}
