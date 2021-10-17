package com.example.employeepayrollapp.service;

import com.example.employeepayrollapp.dto.EmployeePayrollDTO;
import com.example.employeepayrollapp.exception.EmployeePayrollException;
import com.example.employeepayrollapp.model.EmployeePayrollData;
import com.example.employeepayrollapp.repository.EmployeePayrollRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeePayrollService implements IEmployeePayrollService {
    private List<EmployeePayrollData> employeePayrollList = new ArrayList<>();

    @Autowired
    private EmployeePayrollRepository employeePayrollRepository;

    public List<EmployeePayrollData> getEmployeePayrollData() {
        return employeePayrollList;
    }

    public EmployeePayrollData getEmployeePayrollDataById(int Id) {
        return employeePayrollList.stream().filter(id -> id.getEmployeeId() == Id).findFirst().orElseThrow(() ->
                new EmployeePayrollException("Employee id not found"));
    }

    public EmployeePayrollData createEmployeePayrollData(EmployeePayrollDTO employeePayrollDTO) {
        EmployeePayrollData empData = null;
        empData = new EmployeePayrollData(employeePayrollDTO);
        employeePayrollList.add(empData);
        return employeePayrollRepository.save(empData);
    }

    public EmployeePayrollData updateEmployeePayrollData(int Id, EmployeePayrollDTO employeePayrollDTO) {
        EmployeePayrollData empData = this.getEmployeePayrollDataById(Id);
        empData.updateEmployeePayrollData(employeePayrollDTO);
        empData.updateEmployeePayrollData(employeePayrollDTO);
        employeePayrollList.set(Id - 1, empData);
        return empData;
    }

    public void deleteEmployeePayrollData(int Id) {
        employeePayrollList.stream().filter(id-> id.getEmployeeId() == Id).findFirst().orElseThrow(()->
        new EmployeePayrollException("Employee Id Not Found"));
    }
}















