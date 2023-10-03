package com.planner.travel.dto;

import lombok.*;

// Отримуємо всю інформацію про Подорож

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@ToString
public class TripDTO {

    private int id;
    private String name;
    private String author;
    private String description;
    private String datetime;
    private String is_completed;
}
