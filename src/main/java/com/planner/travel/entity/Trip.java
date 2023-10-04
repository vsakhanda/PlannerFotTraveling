package com.planner.travel.entity;


import jakarta.persistence.*;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@Entity
@Table (name = "trips")
public class Trip {

    @Column
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String author;
    private String description;
    private String datetime;
    private String is_completed;

}
