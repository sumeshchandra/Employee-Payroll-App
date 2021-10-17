package com.example.employeepayrollapp.service;

import com.example.employeepayrollapp.dto.EmployeePayrollDTO;
import com.example.employeepayrollapp.model.EmployeePayrollData;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeePayrollService implements IEmployeePayrollService {
    private List<EmployeePayrollData> employeePayrollList = new ArrayList<>();

    public List<EmployeePayrollData> getEmployeePayrollData() {
        return employeePayrollList;
    }

    public EmployeePayrollData getEmployeePayrollDataById(int Id) {
        return employeePayrollList.get(Id - 1);
    }

    public EmployeePayrollData createEmployeePayrollData(EmployeePayrollDTO employeePayrollDTO) {
        EmployeePayrollData empData = null;
        empData = new EmployeePayrollData(employeePayrollList.size() + 1, employeePayrollDTO);
        employeePayrollList.add(empData);
        return empData;
    }

    public EmployeePayrollData updateEmployeePayrollData(int Id, EmployeePayrollDTO employeePayrollDTO) {
        EmployeePayrollData empData = this.getEmployeePayrollDataById(Id);
        empData.setName(employeePayrollDTO.getName());
        empData.setSalary(employeePayrollDTO.getSalary());
        employeePayrollList.set(Id - 1, empData);
        return empData;
    }

    public void deleteEmployeePayrollData(int Id) {
        employeePayrollList.remove(Id - 1);
    }
}















