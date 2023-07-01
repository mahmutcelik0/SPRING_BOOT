package com.mahmutcelik.example.model.unidirectional;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.Hibernate;

import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "TEACHER")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Teacher {
    @Id
    private Long id;
    private String firstName;
    private String lastName;
    private Long phoneNumber;

    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JoinColumn(name = "TEACHER_ID",referencedColumnName = "id")
    @JsonBackReference //TO PREVENT STACKOVERFLOW ERROR -> TO CONVERT RESPONSE TO JSON OBJECT PROGRAM USES TOSTRING AND IN THIS PART IT CAUSES AN ERROR
    //SO THAT WE CAN USE @JSONIGNORE OR @JSONBACKREFERENCE
    @ToString.Exclude
    private List<Student> students;


}
