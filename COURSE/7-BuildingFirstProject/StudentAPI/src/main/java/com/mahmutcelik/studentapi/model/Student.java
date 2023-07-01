package com.mahmutcelik.studentapi.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Getter
@Setter
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "STUDENT_NAME")
    private String firtName;
    @Column(name = "STUDENT_SURNAME")
    private String lastName;
    private Long schoolNumber;
    private Long phoneNumber;
}