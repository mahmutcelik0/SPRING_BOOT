package com.mahmutcelik.studentapi.service;

import com.mahmutcelik.studentapi.model.Student;
import com.mahmutcelik.studentapi.repository.StudentRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService{
    private final StudentRepository repository;
    public StudentService(StudentRepository repository) {
        this.repository = repository;
    }

    public List<Student> getStudents() {
        return repository.findAll();
    }

    public Student addNewStudent(Student student) {
        return repository.save(student);
    }

    public Student updateExistStudent(Student student, Long studentId) {
        repository.deleteById(studentId);
        return repository.save(student);
    }

    public Student getSpecialStudent(String studentName, String studentSurname) {
        return repository.findElement(studentName,studentSurname);
    }

    public Student deleteById(Long id) {
        Optional<Student> temp = repository.findById(id);
        repository.deleteById(id);
        return temp.orElse(null);
    }

    public void deleteByInformation(Long schoolNumber, Long phoneNumber) {
        repository.deleteByInfo(schoolNumber,phoneNumber);
    }
}
