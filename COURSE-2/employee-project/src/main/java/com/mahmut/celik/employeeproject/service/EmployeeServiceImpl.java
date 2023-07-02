package com.mahmut.celik.employeeproject.service;

import com.mahmut.celik.employeeproject.exception.EmployeeNotFoundException;
import com.mahmut.celik.employeeproject.model.Employee;
import com.mahmut.celik.employeeproject.repository.EmployeeRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService{
    private final EmployeeRepository employeeRepository;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee findById(Integer employeeId) {
        Optional<Employee> employee = employeeRepository.findById(employeeId);
        if(employee.isEmpty()){
            throw new EmployeeNotFoundException("EMPLOYEE NOT FOUND IN ID: " + employeeId);
        }
        return employee.get();
    }

    @Override
    @Transactional
    public Employee addEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    @Transactional
    public void deleteEmployee(Integer employeeId) {
        employeeRepository.deleteById(employeeId);
    }

    @Override
    @Transactional
    public Employee updateEmployee(Employee employee) {
        return employeeRepository.save(employee);

    }
}
