package com.planner.travel.dto;

// Отримуємо всю інформацію про маршрут

import lombok.*;


@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@ToString
public class RouteDTO {

        private int id;
        private String name;
        private int author;
        private String description;
        private boolean is_private;
        private boolean is_round_route;
}
