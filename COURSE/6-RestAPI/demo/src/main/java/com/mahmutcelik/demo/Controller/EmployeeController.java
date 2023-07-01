package com.mahmutcelik.demo.Controller;

import com.mahmutcelik.demo.Model.Employee;
import com.mahmutcelik.demo.Service.EmployeeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "api/v1")
public class EmployeeController {

    private final EmployeeService service;

    public EmployeeController(EmployeeService service) {
        this.service = service;
    }

    @GetMapping(value = "getByName")
    public List<Employee> getByNameMethod(String name){
        return service.getByName(name);
    }

    @GetMapping(value = "getBySurname")
    public List<Employee> getBySurname(String surname){
        return service.getBySurname(surname);
    }

    @GetMapping(value = "getByGender")
    public List<Employee> getByGender(String gender){
        return service.getByGender(gender);
    }


    @PostMapping
    public Employee saveEmployee(@RequestBody Employee emp){
        return service.save(emp);
    }

    @PutMapping
    public Employee updateExistEmployee(@RequestParam(value = "id") int methodId, @RequestBody Employee emp){
        return service.update(methodId,emp);
    }

    @DeleteMapping(value = "{id}")
    public void deleteExistEmployee(@PathVariable(value = "id") Integer methodId){
        service.delete(methodId);
    }

    //IN PUT MAPPING THERE IS A PARAMETER IN URL AND VE BIND IT TO VARIABLE AFTER THAT WE USE IT
    //http://localhost:8080/api/v1?id=1 -> id= 1 is parameter -> methodId will bind id -> methodId = 1
    //IN DELETE MAPPING IN URL WE DIRECTLY TAKE THE VALUE AND BIND IT TO VARIABLE AFTER THAT WE USE IT
    //http://localhost:8080/api/v1/2 -> 2 is {id} part and methodId will bind it -> methodId = 2
}

