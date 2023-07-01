package com.mahmutcelik.demo3manytomany.service.course;

import com.mahmutcelik.demo3manytomany.model.Course;

import java.util.List;

public interface CourseService {
    List<Course> getAllCourses();

    Course getCourseById(Long id);
}
