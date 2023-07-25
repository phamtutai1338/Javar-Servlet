package com.example.apidemoemp.service;

import com.example.apidemoemp.entity.Employee;

import java.util.List;

public interface EmployeeService {
    public List<Employee> findAll();

    public Employee findById(int theId);

    public void save(Employee theEmployee);

    void deleteById(int theId);

    List<Employee> searchBy(String theName);
}
