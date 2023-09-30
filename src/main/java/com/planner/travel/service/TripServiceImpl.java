package com.planner.travel.service;

import com.planner.travel.model.Trip;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class TripServiceImpl implements TripService{

        private Map<Integer, Trip> trips = new HashMap<>();

        // DAO layer 48.44
        @Override
        public Trip getById(int id) {
            return trips.get(id);
        }

        @Override
        public Trip add(Trip trip) {
            trips.put(trip.getId(), trip);
            return trip;
        }

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

}
