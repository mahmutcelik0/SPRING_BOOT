package com.mahmutcelik.demo2onetoone.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "ADDRESS")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Address {

    //--ONE TO ONE NORMAL VERSION
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String street;
    private String city;

    @OneToOne(mappedBy = "address",cascade = CascadeType.ALL)
    private Users user;



}