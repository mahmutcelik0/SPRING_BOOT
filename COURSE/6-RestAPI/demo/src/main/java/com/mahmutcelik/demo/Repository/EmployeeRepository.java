package com.mahmutcelik.demo.Repository;

import com.mahmutcelik.demo.Model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Integer> {
    List<Employee> findByName(String name);
    List<Employee> findBySurname(String surname);
    List<Employee> findByGender(String gender);

}
