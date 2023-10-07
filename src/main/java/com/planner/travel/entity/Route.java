package com.planner.travel.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@Entity
@Table (name = "routes")
public class Route {

    @Column
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
//    @ManyToOne
//    @JoinTable (name = "User")
//    @JoinColumn (name = "id")
    private int author;
    private String description;
//    private String startpoint;
//    private String endpoint;
    private boolean is_private;
    private boolean is_round_route;

    //point<List point>;


}
