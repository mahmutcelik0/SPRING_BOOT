package com.mahmut.celik.employeeproject.dao;

import com.mahmut.celik.employeeproject.model.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeDAOImpl implements EmployeeDAO{

    private EntityManager entityManager;

    @Autowired
    public EmployeeDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Employee> findAll() {
        TypedQuery<Employee> query = entityManager.createQuery("from Employee ",Employee.class);

        List<Employee> employees = query.getResultList();

        return employees;
    }

    @Override
    public Employee findById(Integer employeeId) {
        Employee employee = entityManager.find(Employee.class,employeeId);

        return employee;
    }

    @Override
    public Employee addEmployee(Employee employee) {
        Employee e1 = entityManager.merge(employee);
        return e1;
    }

    @Override
    public Employee deleteEmployee(Integer employeeId) {
        Employee employee = entityManager.find(Employee.class,employeeId);

        entityManager.remove(employee);
        return employee;
    }

    @Override
    public Employee updateEmployee(Employee employee) {
        Employee e1 = entityManager.merge(employee);
        return e1;
    }

    // add or update için merge id == 0 sa ekler değilse update - Transactional ı burada eklemeyeceğiz -> Service layer da halledeceğiz
}
