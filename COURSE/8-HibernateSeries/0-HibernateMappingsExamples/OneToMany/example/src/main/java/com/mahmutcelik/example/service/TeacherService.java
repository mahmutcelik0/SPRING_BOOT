package com.mahmutcelik.example.service;

import com.mahmutcelik.example.dto.TeacherDto;
import com.mahmutcelik.example.model.unidirectional.Teacher;

import java.util.List;

public interface TeacherService {
    List<Teacher> getTeachers();
}
