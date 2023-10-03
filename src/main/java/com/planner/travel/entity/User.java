package com.planner.travel.entity;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.sql.Date;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@Entity
@Table
public class User implements Serializable {

    @Column
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String surname;
    private String email;
    private String phone;
    private String country;
    private String city;
    private Date dob;

//    @ManyToMany
//    @JoinTable(
//            name = "user_roles",
//            joinColumns = {
//                    @JoinColumn(
//                            name = "user_id",
//                            nullable = false
//                    )
//            },
//            inverseJoinColumns = {
//                    @JoinColumn(
//                            name = "role_id",
//                            nullable = false
//                    )
//            }
//    )
    private int Role;

}
