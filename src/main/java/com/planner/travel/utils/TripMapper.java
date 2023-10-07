package com.planner.travel.utils;
import com.planner.travel.dto.TripDTO;
import com.planner.travel.entity.Trip;
import org.springframework.stereotype.Component;

@Component
public class TripMapper {

    public TripDTO toDTO(Trip trip) {
        TripDTO dto = new TripDTO();
        dto.setId(trip.getId());
        dto.setName(trip.getName());
        dto.setAuthor(trip.getAuthor());
        dto.setDescription(trip.getDescription());
        dto.setIs_completed(trip.getIs_completed());
        dto.setDatetime(trip.getDatetime());
        // Перетворення інших полів за потребою
        return dto;
    }

    public Trip toEntity(TripDTO tripDTO) {
        Trip trip = new Trip();
        trip.setId(tripDTO.getId());
        trip.setName(tripDTO.getName());
        trip.setAuthor(tripDTO.getAuthor());
        trip.setDescription(tripDTO.getDescription());
        trip.setIs_completed(tripDTO.getIs_completed());
        trip.setDatetime(tripDTO.getDatetime());

        // Перетворення інших полів за потребою
        return trip;

    }

}
