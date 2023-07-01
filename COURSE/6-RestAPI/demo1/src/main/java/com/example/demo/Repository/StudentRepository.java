package com.example.demo.Repository;

import com.example.demo.Model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student,Long> {
    List<Student> findByName(String name);
    List<Student> findBySurname(String surname);
    List<Student> findByPhoneNumber(String phoneNumber);
    List<Student> findByStudentNumber(String studentNumber);

    void deleteByName(String name);

    void deleteBySurname(String surname);

    void deleteByPhoneNumber(String phoneNumber);

    void deleteByStudentNumber(String studentNumber);

}
