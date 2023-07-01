package com.mahmutcelik.demo;

import com.mahmutcelik.demo.Model.Employee;
import com.mahmutcelik.demo.Repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class EmployeeCommandLineRunner implements CommandLineRunner {
    @Autowired
    EmployeeRepository repository;

    @Override
    public void run(String... args) throws Exception {
        repository.save(new Employee(1,"MAHMUT","CELIK","E"));
        repository.save(new Employee(2,"MAHMUT","CELIK","E"));
        repository.save(new Employee(3,"MAHMUT","CELIK","E"));
        repository.save(new Employee(4,"MAHMUT","CELIK","E"));
    }
}
