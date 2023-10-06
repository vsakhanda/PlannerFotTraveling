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
@ToString
@Data
@Table (name = "users")
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String surname;
    private String phone;
    private String email;
    private String country;
    private String city;


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
}
