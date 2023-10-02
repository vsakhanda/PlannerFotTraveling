package com.planner.travel.entity;


import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@Entity
@Table
    public class Point implements Serializable {

    @Column
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @OneToMany(mappedBy = "point_id")
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
