package com.example.demo.Controller;

import com.example.demo.Model.Student;
import com.example.demo.Service.StudentService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/v2")
public class StudentController {
    private final StudentService service;

    public StudentController(StudentService service) {
        this.service = service;
    }

    @GetMapping("/{id}")
    public Optional<Student> getById(@PathVariable(value="id") Long studentId){
        return service.getById(studentId);
    }

    @GetMapping("/getByName")
    public List<Student> getByName(@RequestParam(value = "name") String methodName){
        return service.getByName(methodName);
    }

    @GetMapping("/getBySurname")
    public List<Student> getBySurname(@RequestParam(value = "surname") String methodSurname){
        return service.getBySurname(methodSurname);
    }

    @GetMapping("/getByPhoneNumber")
    public List<Student> getbyPhoneNumber(@RequestParam(value = "phoneNumber") String methodPhoneNumber){
        return service.getByPhoneNumber(methodPhoneNumber);
    }

    @GetMapping("/getByStudentNumber")
    public List<Student> getByStudentNumber (@RequestParam(value = "studentNumber") String methodStudentNumber){
        return service.getByStudentNumber(methodStudentNumber);
    }

    //IT SELECTS AUTOMATICALLY NEW ID
    @PostMapping
    public Student postStudent(@RequestBody Student newStudent){
        return service.postNewStudent(newStudent);
    }

    @DeleteMapping("{id}")
    public void deleteById(@PathVariable("id") Long id){
        service.deleteById(id);
    }

    @DeleteMapping("/deleteByName")
    public void deleteByName(@RequestParam(value = "name") String name){
        service.deleteByName(name);
    }

    @DeleteMapping("/deleteBySurname")
    public void deleteBySurname(@RequestParam(value = "surname") String surname){
        service.deleteBySurname(surname);
    }

    @DeleteMapping("/deleteByPhoneNumber")
    public void deleteByPhoneNumber(@RequestParam(value = "phoneNumber") String phoneNumber){
        service.deleteByPhoneNumber(phoneNumber);
    }

    @DeleteMapping("/deleteByStudentNumber")
    public void deleteByStudentNumber(@RequestParam(value = "studentNumber")String studentNumber){
        service.deleteByStudentNumber(studentNumber);
    }

    @PutMapping("{id}")
    public Student putNewStudent(@PathVariable("id") Long id, @RequestBody Student newValues){
        return service.putNewValues(id,newValues);
    }
}
