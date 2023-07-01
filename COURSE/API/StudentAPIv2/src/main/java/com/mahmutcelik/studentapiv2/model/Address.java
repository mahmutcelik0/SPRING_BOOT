package com.mahmutcelik.studentapiv2.model;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

import java.math.BigDecimal;

@Entity(name = "ADDRESS")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Address {
    @Id
    private String buildingName;
    private String townName;
    private String streetName;
    private String cityName;
    private BigDecimal flatNumber;
}
