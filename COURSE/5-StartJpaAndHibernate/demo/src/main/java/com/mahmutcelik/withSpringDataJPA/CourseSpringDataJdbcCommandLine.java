package com.mahmutcelik.withSpringDataJPA;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class CourseSpringDataJdbcCommandLine implements CommandLineRunner {
    @Autowired
    private CourseSpringDataJpaRepository repository;

    @Override
    public void run(String... args) throws Exception {
        repository.save(new Course(1,"AA","BB"));
        repository.save(new Course(2,"AA","BB"));
        repository.save(new Course(3,"AA","BB"));

        repository.deleteById(1L); //we must send Long value as parameter (use uppercase L)-> 1L , 2L ,3L...

//        System.out.println(repository.findById(2L));
//        System.out.println(repository.findById(3L));

        System.out.println(repository.findAll()); // [Course{id=2, aname='AA', author='BB'}, Course{id=3, aname='AA', author='BB'}]
        System.out.println(repository.count()); // 2

        System.out.println(repository.findByAuthor("BB"));
        System.out.println(repository.findByAuthor(""));

        System.out.println(repository.findByAname("AA"));
        System.out.println(repository.findByAname(""));

    }
}
