package com.mahmutcelik.example.controller;

import com.mahmutcelik.example.dto.StudentDto;
import com.mahmutcelik.example.dto.TeacherDto;
import com.mahmutcelik.example.model.unidirectional.Student;
import com.mahmutcelik.example.model.unidirectional.Teacher;
import com.mahmutcelik.example.service.StudentService;
import com.mahmutcelik.example.service.TeacherService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/v1")
public class StudentController {

    private final StudentService studentService;
    private final TeacherService teacherService;


    public StudentController(StudentService studentService, TeacherService teacherService) {
        this.studentService = studentService;
        this.teacherService = teacherService;
    }

    @GetMapping( "/student")
    private List<Student> getStudent(){
        return studentService.getStudents();
    }

    @GetMapping("/teacher")
    private List<Teacher> getTeacher(){
        return teacherService.getTeachers();
    }
}
