package com.mahmutcelik.demo2onetoone.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "USERS")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Users {
    //--ONE TO ONE NORMAL VERSION
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    @Column(name = "address_id")
    private Long addressId;

    @OneToOne
    @JoinColumn(name = "address_id",insertable = false,updatable = false)
    @JsonIgnore
    private Address address;
}
