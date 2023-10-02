package com.planner.travel.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@Entity
@Table
public class TripCompanion {

    @Column
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int id;
    private int trip_id;
    private int companion_id;
    private boolean is_rejected;
    private Date date_rejection;
    private boolean is_approved;
    private Date date_approving;
}
