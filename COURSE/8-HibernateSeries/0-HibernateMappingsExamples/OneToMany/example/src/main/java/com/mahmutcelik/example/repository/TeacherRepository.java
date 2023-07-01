package com.mahmutcelik.example.repository;

import com.mahmutcelik.example.model.unidirectional.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeacherRepository extends JpaRepository<Teacher,Long> {
}
