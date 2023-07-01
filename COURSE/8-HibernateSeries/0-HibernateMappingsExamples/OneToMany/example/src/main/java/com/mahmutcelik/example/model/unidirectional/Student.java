package com.mahmutcelik.example.model.unidirectional;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "STUDENT")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String lastName;
    private Long phoneNumber;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "TEACHER_ID")
    private Teacher teacher;
}
