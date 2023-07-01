package com.mahmutcelik.demo.controller;

import com.mahmutcelik.demo.model.Student;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("api/v1/student")
public class StudentController {
    @GetMapping
    public List<Student> getStudents() {
        List<Student> students = Arrays.asList(
                new Student(1, "AA", "BB", true),
                new Student(2, "CC", "DD", true)
        );

        return students;
    }

    @GetMapping("/{studentId}")
    public Student getSingleStudent(@PathVariable Integer studentId){
        return new Student(studentId,"CC","DD",false);
    }

}
