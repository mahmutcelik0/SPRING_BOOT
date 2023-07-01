package com.mahmutcelik.withSpringDataJPA;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface CourseSpringDataJpaRepository extends JpaRepository<Course,Long> { // First part of dimension is entity class, second part of dimension is entity's id type
    List<Course> findByAuthor(String author);
    List<Course> findByAname(String aname);


}
