package com.planner.travel.dto;

import lombok.*;

// Отримуємо інформацію про Точку

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@ToString
public class PointDTO {

    private int id;
    private String name;
    private double latitude;
    private double longitude;
    private String description;
    private String point_adress;
    private String phone_number;
    private String link;
    private String district;
    private String regions ;
}
