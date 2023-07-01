package com.mahmutcelik.demo3manytomany.service.student;

import com.mahmutcelik.demo3manytomany.model.Student;
import com.mahmutcelik.demo3manytomany.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class StudentServiceImpl implements StudentService{
    private final StudentRepository studentRepository;

    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    @Override
    public Student getStudentById(Long id) {
        return studentRepository.findById(id).get();
    }

    @Override
    public List<Object> getJoinResults() {
        return studentRepository.getJoinResult();
    }
}
