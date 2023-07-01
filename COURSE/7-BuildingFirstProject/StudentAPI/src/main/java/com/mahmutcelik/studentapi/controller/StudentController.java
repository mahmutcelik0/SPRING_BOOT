package com.mahmutcelik.studentapi.controller;

import com.mahmutcelik.studentapi.model.Student;
import com.mahmutcelik.studentapi.service.StudentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1")
public class StudentController {
    private static final Logger logger = LoggerFactory.getLogger(StudentController.class);

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping
    public List<Student> getStudents(){
        return studentService.getStudents();
    }
    @GetMapping("/info")
    public Student getSpecialStudent(@RequestParam("name") String studentName, @RequestParam("surname") String studentSurname){
        return studentService.getSpecialStudent(studentName,studentSurname);
    }
    @PostMapping
    public Student addNewStudent(@RequestBody Student student){
        return studentService.addNewStudent(student);
    }

    @PutMapping("/{id}")
    public Student updateExistStudent(@RequestBody Student student , @PathVariable("id") Long studentId){
        return studentService.updateExistStudent(student,studentId);
    }

    @DeleteMapping("/{id}")
    public Student deleteById(@PathVariable("id") Long id){
        return studentService.deleteById(id);
    }

    @DeleteMapping("/info")
    public void deleteByInformation(@RequestParam("schoolNumber") Long schoolNumber, @RequestParam("phoneNumber") Long phoneNumber){
        studentService.deleteByInformation(schoolNumber,phoneNumber);
    }
}
