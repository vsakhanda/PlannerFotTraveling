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
public class PointComment {

    @Column
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int id;
    private int point_id;
    private String description;
    private String user_id;
    private Date timestamp;
    private boolean is_deleted;

}
