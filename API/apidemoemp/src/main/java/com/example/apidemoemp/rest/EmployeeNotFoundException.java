package com.example.apidemoemp.rest;

public class EmployeeNotFoundException extends RuntimeException{
    private Integer employeeId;

    public EmployeeNotFoundException(Integer employeeId){
        super("Employee not found with ID : " + employeeId);
        this.employeeId = employeeId;
    }


}
