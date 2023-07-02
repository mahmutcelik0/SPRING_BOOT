package com.mahmut.celik.employeeproject.service;

import com.mahmut.celik.employeeproject.dao.EmployeeDAO;
import com.mahmut.celik.employeeproject.exception.EmployeeNotFoundException;
import com.mahmut.celik.employeeproject.model.Employee;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService{
    private final EmployeeDAO employeeDAO;

    public EmployeeServiceImpl(EmployeeDAO employeeDAO) {
        this.employeeDAO = employeeDAO;
    }

    @Override
    public List<Employee> findAll() {
        return employeeDAO.findAll();
    }

    @Override
    public Employee findById(Integer employeeId) {
        Employee employee = employeeDAO.findById(employeeId);
        if(employee == null){
            throw new EmployeeNotFoundException("EMPLOYEE NOT FOUND IN ID: " + employeeId);
        }
        return employee;
    }

    @Override
    @Transactional
    public Employee addEmployee(Employee employee) {
        return employeeDAO.addEmployee(employee);
    }

    @Override
    @Transactional
    public Employee deleteEmployee(Integer employeeId) {
        return employeeDAO.deleteEmployee(employeeId);
    }

    @Override
    @Transactional
    public Employee updateEmployee(Employee employee) {
        Employee employee1 = employeeDAO.updateEmployee(employee);

        if (employee1 == null){
            throw new EmployeeNotFoundException("EMPLOYEE NOT EXIST IN: " + employee.getId());
        }

        return employee1;
    }
}
