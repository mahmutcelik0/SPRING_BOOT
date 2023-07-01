package com.example.demo.Service;


import com.example.demo.Model.Student;
import com.example.demo.Repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {
    private final StudentRepository repository;

    public StudentService(StudentRepository repository) {
        this.repository = repository;
    }

    public Optional<Student> getById(Long id){
        return repository.findById(id);
    }

    public List<Student> getByName(String name){
        return repository.findByName(name);
    }

    public List<Student> getBySurname(String surname){
        return repository.findBySurname(surname);
    }

    public List<Student> getByPhoneNumber(String phoneNumber){
        return repository.findByPhoneNumber(phoneNumber);
    }

    public List<Student> getByStudentNumber(String studentNumber){
        return repository.findByStudentNumber(studentNumber);
    }

    public Student postNewStudent(Student newStudent){
        return repository.save(newStudent);
    }

    public void deleteById(Long id){
        repository.deleteById(id);
    }

    public void deleteByName(String name){
        repository.deleteByName(name);
    }

    public void deleteBySurname(String surname){
        repository.deleteBySurname(surname);
    }

    public void deleteByPhoneNumber(String phoneNumber){
        repository.deleteByPhoneNumber(phoneNumber);
    }

    public void deleteByStudentNumber(String studentNumber){
        repository.deleteByStudentNumber(studentNumber);
    }

    public Student putNewValues(Long id,Student newStudent){
        Student currentStudent = repository.findById(id).get();

        currentStudent.setName(newStudent.getName());
        currentStudent.setSurname(newStudent.getSurname());
        currentStudent.setPhoneNumber(newStudent.getPhoneNumber());
        currentStudent.setStudentNumber(newStudent.getStudentNumber());

        return repository.save(currentStudent);
    }


}
