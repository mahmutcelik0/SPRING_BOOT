package com.mahmut.celik.employeeproject.service;

import com.mahmut.celik.employeeproject.model.Employee;

import java.util.List;

public interface EmployeeService {
    List<Employee> findAll();

    Employee findById(Integer employeeId);

    Employee addEmployee(Employee employee);

    Employee deleteEmployee(Integer employeeId);

    Employee updateEmployee(Employee employee);
}
