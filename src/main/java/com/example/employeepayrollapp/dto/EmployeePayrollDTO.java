package com.example.employeepayrollapp.dto;


import lombok.Data;

@Data
public class EmployeePayrollDTO {

    private String name;
    private double Salary;

    public EmployeePayrollDTO(String name, double salary) {
        this.name = name;
        this.Salary = salary;
    }
}
