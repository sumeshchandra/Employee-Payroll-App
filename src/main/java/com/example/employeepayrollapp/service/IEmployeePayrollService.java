package com.example.employeepayrollapp.service;

import com.example.employeepayrollapp.dto.EmployeePayrollDTO;
import com.example.employeepayrollapp.model.EmployeePayrollData;

import java.util.List;

public interface IEmployeePayrollService {
    List<EmployeePayrollData> getEmployeePayrollData();

    EmployeePayrollData getEmployeePayrollDataById(int Id);

    EmployeePayrollData createEmployeePayrollData(
            EmployeePayrollDTO employeePayrollDTO);

    EmployeePayrollData updateEmployeePayrollData(
            int ID ,EmployeePayrollDTO employeePayrollDTO);

    void deleteEmployeePayrollData(int id);
}
