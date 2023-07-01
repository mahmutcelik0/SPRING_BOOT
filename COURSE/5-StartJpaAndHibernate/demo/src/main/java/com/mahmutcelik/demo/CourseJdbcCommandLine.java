package com.mahmutcelik.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;


//BELOW CLASS WORKS ON BEGINNING OF SPRING BOOT PROGRAM (LIKE INITIALIZABLE)
@Component
public class CourseJdbcCommandLine implements CommandLineRunner {
    @Autowired
    private CourseJdbcRepository repository;


    @Override
    public void run(String... args) throws Exception {
        repository.insert();
    }
}
