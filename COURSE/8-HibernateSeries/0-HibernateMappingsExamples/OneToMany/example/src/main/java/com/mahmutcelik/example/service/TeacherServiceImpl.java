package com.mahmutcelik.example.service;

import com.mahmutcelik.example.dto.TeacherDto;
import com.mahmutcelik.example.model.unidirectional.Teacher;
import com.mahmutcelik.example.repository.TeacherRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeacherServiceImpl implements TeacherService{
    private final TeacherRepository teacherRepository;

    public TeacherServiceImpl(TeacherRepository teacherRepository) {
        this.teacherRepository = teacherRepository;
    }

    @Override
    public List<Teacher> getTeachers() {
        return teacherRepository.findAll();
    }
}