package com.mahmutcelik.withJPAandEntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class CourseJdbcCommandLine implements CommandLineRunner {
    @Autowired
    private JpaRepository repository;

    @Override
    public void run(String... args) throws Exception {
        repository.insert(new Course(1,"AA","TT"));
        repository.insert(new Course(2,"AA","TT"));
        repository.insert(new Course(3,"AA","TT"));

        repository.deleteById(2);

        System.out.println(repository.findById(1));
        System.out.println(repository.findById(3));

    }
}
