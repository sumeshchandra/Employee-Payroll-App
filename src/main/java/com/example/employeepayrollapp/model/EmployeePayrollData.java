package com.example.employeepayrollapp.model;

import com.example.employeepayrollapp.dto.EmployeePayrollDTO;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@Entity
public class EmployeePayrollData {

    @Id
    private int Id;
    private String name;
    private double salary;

    public EmployeePayrollData(int Id, EmployeePayrollDTO employeePayrollDTO) {
        this.Id = Id;
        this.name = employeePayrollDTO.getName();
        this.salary = employeePayrollDTO.getSalary();
    }

    public EmployeePayrollData() {

    }
}
