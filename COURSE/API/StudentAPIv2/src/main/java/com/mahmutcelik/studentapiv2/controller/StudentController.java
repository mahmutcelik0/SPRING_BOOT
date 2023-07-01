package com.mahmutcelik.studentapiv2.controller;

import com.mahmutcelik.studentapiv2.dto.StudentDto;
import com.mahmutcelik.studentapiv2.service.StudentService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/v1")
public class StudentController {
    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping
    public List<StudentDto> getAllStudentsDto(){
        return studentService.getAllStudentsDto();
    }
}
