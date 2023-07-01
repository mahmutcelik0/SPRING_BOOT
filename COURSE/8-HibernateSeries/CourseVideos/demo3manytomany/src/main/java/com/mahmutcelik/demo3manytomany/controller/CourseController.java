package com.mahmutcelik.demo3manytomany.controller;

import com.mahmutcelik.demo3manytomany.model.Course;
import com.mahmutcelik.demo3manytomany.service.course.CourseService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/course")
public class CourseController {
    private final CourseService courseService;

    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    @GetMapping
    private List<Course> getAllCourses(){
        return courseService.getAllCourses();
    }

    @GetMapping("/{id}")
    private Course getCourseById(@PathVariable Long id){
        return courseService.getCourseById(id);
    }



}
