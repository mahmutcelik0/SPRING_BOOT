package com.mahmutcelik.studentapi.repository;

import com.mahmutcelik.studentapi.model.Student;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student,Long> {
    @Query("select s from Student s where s.firtName = ?1 AND s.lastName = ?2")
    Student findElement(String studentName, String studentSurname);

    @Modifying
    @Transactional
    @Query("DELETE Student s WHERE s.schoolNumber = ?1 AND s.phoneNumber = ?2")
    void deleteByInfo(Long schoolNumber,Long phoneNumber);

}
