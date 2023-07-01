package com.mahmutcelik.demo3manytomany.service.student;

import com.mahmutcelik.demo3manytomany.model.Student;

import java.util.List;

public interface StudentService {
    List<Student> getAllStudents();

    Student getStudentById(Long id);

    List<Object> getJoinResults();
}
