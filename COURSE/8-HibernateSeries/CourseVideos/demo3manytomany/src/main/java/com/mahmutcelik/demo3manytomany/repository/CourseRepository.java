package com.mahmutcelik.demo3manytomany.repository;

import com.mahmutcelik.demo3manytomany.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRepository extends JpaRepository<Course,Long> {
}
