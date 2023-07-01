package com.mahmutcelik.example.repository;

import com.mahmutcelik.example.model.unidirectional.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student,Long> {
}