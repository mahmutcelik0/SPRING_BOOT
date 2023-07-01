package com.mahmutcelik.demo3manytomany.controller;

import com.mahmutcelik.demo3manytomany.model.Student;
import com.mahmutcelik.demo3manytomany.repository.StudentRepository;
import com.mahmutcelik.demo3manytomany.service.student.StudentService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/student")
public class StudentController {
    private final StudentService studentService;

    public StudentController(StudentService studentService, StudentRepository studentRepository) {
        this.studentService = studentService;
    }

    @GetMapping
    private List<Student> getAllStudents(){
        return studentService.getAllStudents();
    }


    @GetMapping("/{id}")
    private Student getStudentById(@PathVariable Long id){
        return studentService.getStudentById(id);
    }

    @GetMapping("/join")
    private List<Object> getJoinResults(){
        return studentService.getJoinResults();
    }

}
