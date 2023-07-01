package com.mahmutcelik.example.service;

import com.mahmutcelik.example.dto.StudentDto;
import com.mahmutcelik.example.model.unidirectional.Student;
import com.mahmutcelik.example.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService{
    private final StudentRepository studentRepository;

    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public List<Student> getStudents() {
        return studentRepository.findAll();
    }
}
