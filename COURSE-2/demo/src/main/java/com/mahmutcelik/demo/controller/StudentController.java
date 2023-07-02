package com.mahmutcelik.demo.controller;

import com.mahmutcelik.demo.exception.StudentErrorResponse;
import com.mahmutcelik.demo.exception.StudentNotFoundException;
import com.mahmutcelik.demo.model.Student;
import jakarta.annotation.PostConstruct;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("api/v1/student")
public class StudentController {
    private List<Student> students;

    @PostConstruct
    private void addStudents() {
        students = Arrays.asList(
                new Student(1, "AA", "BB", true),
                new Student(2, "CC", "DD", true)
        );
    }

    @GetMapping
    public List<Student> getStudents() {
        return students;
    }

    // Alttaki yapıda exception handle ediliyor ve response status 200 fakat sistem içerisinde stack trace bastırılmış oluyor ve program çalışmaya devam edebilir
    // Exception handle edilmediği durumda response olarak 500 status code u dönüyor yani internal(seruer) error anlamına geliyor
//    @GetMapping("/{studentId}")
//    public Student getSingleStudent(@PathVariable Integer studentId) {
//        try {
//            return students.get(studentId);
//        } catch (ArrayIndexOutOfBoundsException e) {
//            e.printStackTrace();
//        }
//        return null;
//    }


    @GetMapping("/{studentId}")
    public Student getSingleStudent(@PathVariable int studentId){
        if(studentId>=students.size() || studentId< 0){
            throw new StudentNotFoundException("STUDENT NOT FOUND IN ID: "+ studentId);
        }
        return students.get(studentId);
    }

}
