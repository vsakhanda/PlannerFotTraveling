package com.planner.travel.dto;

import com.planner.travel.entity.Role;
import lombok.*;

import java.util.List;


@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@ToString
public class AdminUserDTO {

    private int id;
    private String name;
    private String surname;
    private String email;
    private String phone;
    private String country;
    private String city;
    //private String role;
    private List<RoleDTO> roleList;
}
