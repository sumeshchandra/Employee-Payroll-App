package com.example.employeepayrollapp.dto;


import com.sun.istack.NotNull;
import lombok.Data;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;

@Data
public class EmployeePayrollDTO {

    @NotNull
    @Pattern(regexp = "^[A-Z]{1}[a-zA-Z]{2,}$", message = "Enter Proper Name")
    private String name;

    @NotNull
    @Min(value = 1000, message = "Salary greater than 1000")
    @Max(value = 10000, message = "salary less than 10000")
    private double Salary;

    public EmployeePayrollDTO(String name, double salary) {
        this.name = name;
        this.Salary = salary;
    }
}
