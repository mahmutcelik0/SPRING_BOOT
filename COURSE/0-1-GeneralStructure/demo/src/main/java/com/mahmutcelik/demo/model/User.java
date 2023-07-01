package com.mahmutcelik.demo.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Entity(name = "USERS") //USER KEYWORD IS RESERVED IN SPRING DATA JPA
@Table
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @Id
    private String username;
    private String password;
    private String city;
    private Long phoneNumber;
    private Boolean isAdmin;
    @Column(name = "USER_SALARY")
    private BigDecimal salary;
}
