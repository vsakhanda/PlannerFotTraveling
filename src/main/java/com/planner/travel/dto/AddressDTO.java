package com.planner.travel.dto;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter

//Отримуємо інформацію про адресу точки

public class AddressDTO {

    private int id;
    private String counrty;
    private String city;
    private String address;
    private String phone;
    private String region;
    private String description;

}
