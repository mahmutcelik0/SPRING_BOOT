package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;


@Entity
@Table(name = "USER_PROFILE")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserProfile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String phoneNumber;
    private String address;
    @Enumerated(EnumType.STRING)
    private GENDER gender;
    private LocalDate birthOfDate;

    @OneToOne(cascade = CascadeType.ALL,mappedBy = "userProfile") //LAZY YAPMAK ETKILEMEYECEK
    //MAPPEDBY EKLENMEK ZORUNDA BU ENTITY NIN HANGI FIELD TARAFINDAN MAPLENDIGINI BELIRTIR USER.up_id -> UserProfile.id (up_id foreign key and userprofile.id is primary key)
    //
    private User user;


}
