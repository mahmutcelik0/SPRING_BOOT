package com.mahmutcelik.demo.Service;

import com.mahmutcelik.demo.Model.Employee;
import com.mahmutcelik.demo.Repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    private final EmployeeRepository repository;

    @Autowired
    public EmployeeService(EmployeeRepository repository) {
        this.repository = repository;
    }

    public List<Employee> getByName(String name){
        return repository.findByName(name);
    }

    public List<Employee> getBySurname(String surname){
        return repository.findBySurname(surname);
    }

    public List<Employee> getByGender(String gender){
        return repository.findByGender(gender);
    }

    public Employee save(Employee employee){
        return repository.save(employee);
    }

    public Employee update(Integer id, Employee employee){
        Employee existEmp = repository.findById(id).get();

        existEmp.setName(employee.getName());
        existEmp.setSurname(employee.getSurname());
        existEmp.setGender(employee.getGender());

        return repository.save(existEmp);
    }


    public void delete(Integer id){

        repository.deleteById(id);
    }


}
