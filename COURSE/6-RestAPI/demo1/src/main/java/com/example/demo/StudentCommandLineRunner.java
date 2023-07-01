package com.example.demo;

import com.example.demo.Model.Student;
import com.example.demo.Repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class StudentCommandLineRunner implements CommandLineRunner {
    @Autowired
    private StudentRepository repository;

    @Override
    public void run(String... args) throws Exception {
        repository.save(new Student("MAHMUT","CELIK","05466053396","05190000114"));
    }
}
