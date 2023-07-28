package com.example.apidemoemp.rest;

import com.example.apidemoemp.dao.EmployeeRepository;
import com.example.apidemoemp.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.persistence.Id;
import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {
    private EmployeeRepository repository;

    @Autowired
    public EmployeeRestController(EmployeeRepository theEmployeeRepository){
        repository=theEmployeeRepository;
    }
    //lay du lieu emp
    @GetMapping("/emp")
    public List<Employee> all(){return repository.findAll();}
    //them moi emp
    @PostMapping("/emp")
    public Employee newEmployee(@RequestBody Employee newEmployee){
        return repository.save(newEmployee);
    }
    @PutMapping("/emp/{id}")
    Employee updateEmp(@RequestBody Employee updateEmp, @PathVariable Integer id) {
        return repository.findById(id)

                .map(employee -> {
                    employee.setFirstName(updateEmp.getFirstName());
                    employee.setLastName(updateEmp.getLastName());
                    employee.setEmail(updateEmp.getEmail());
                    return repository.save(employee);
                })
                .orElseThrow(() -> new EmployeeNotFoundException(id));
    }
    @GetMapping("/emp/{id}")
    public Employee one(@PathVariable Integer id){
        return repository.findById(id)
                .orElseThrow(() -> new EmployeeNotFoundException(id));
    }
    @DeleteMapping("/emp/{id}")
    void deleteEmployee(@PathVariable Integer id){
        repository.deleteById(id);
    }
}
