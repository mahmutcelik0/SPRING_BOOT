package com.mahmutcelik.example.service;

import com.mahmutcelik.example.dto.StudentDto;
import com.mahmutcelik.example.model.unidirectional.Student;

import java.util.List;

public interface StudentService {
    List<Student> getStudents();
}
