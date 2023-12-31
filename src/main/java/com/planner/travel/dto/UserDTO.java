package com.planner.travel.dto;

import lombok.*;

import java.sql.Date;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@ToString
public class UserDTO {

        private int id;
        private String name;
        private String surname;
        private String email;
        private String phone;
        private String country;
        private String city;
}
