package com.mahmutcelik.studentapiv2.model;


import jakarta.persistence.*;
import lombok.*;

@Entity(name = "STUDENT")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "STUDENT_NAME")
    private String firstName;
    @Column(name = "STUDENT_SURNAME")
    private String lastName;
    private Long schoolNumber;
    private Long phoneNumber;
    @ManyToOne(fetch = FetchType.EAGER,optional = false)
    private Address address;

}
