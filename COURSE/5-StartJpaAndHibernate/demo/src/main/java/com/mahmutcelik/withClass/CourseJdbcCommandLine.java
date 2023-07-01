package com.mahmutcelik.withClass;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class CourseJdbcCommandLine implements CommandLineRunner {
    @Autowired
    private CourseJdbcRepository courseJdbcRepository;

    @Override
    public void run(String... args) throws Exception {
        courseJdbcRepository.insert(new Course(1,"CC","DD"));
        courseJdbcRepository.insert(new Course(2,"EE","FF"));
        courseJdbcRepository.insert(new Course(3,"GG","HH"));


        courseJdbcRepository.delete(new Course(2,"EE","FF"));


        System.out.println(courseJdbcRepository.findById(1));
        System.out.println(courseJdbcRepository.findById(3));
    }
}
