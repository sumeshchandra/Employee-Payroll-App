package com.example.employeepayrollapp.model;

import com.example.employeepayrollapp.dto.EmployeePayrollDTO;
import lombok.Data;


import javax.persistence.*;
import javax.validation.constraints.PastOrPresent;
import java.time.LocalDate;
import java.util.List;

@Data
@Entity
@Table(name = "employee_roll")
public class EmployeePayrollData {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "employee_id")
    private int employeeId;

    @Column(name = "name")
    private String name;
    private long salary;
    private String gender;
    private @PastOrPresent(message = "Current Date or Past Date") LocalDate startDate;
    private String note;
    private String profilePic;


    @ElementCollection
    @CollectionTable(name = "employee_department", joinColumns = @JoinColumn(name = "id"))
    @Column(name = "department")
    private List<String> departments;


    public EmployeePayrollData() {

    }

    public EmployeePayrollData(EmployeePayrollDTO employeePayrollDTO) {
        this.updateEmployeePayrollData(employeePayrollDTO);
    }


    public void updateEmployeePayrollData(EmployeePayrollDTO employeePayrollDTO) {
        this.name = employeePayrollDTO.name;
        this.salary = employeePayrollDTO.salary;
        this.gender = employeePayrollDTO.gender;
        this.startDate = employeePayrollDTO.startDate;
        this.note = employeePayrollDTO.note;
        this.profilePic = employeePayrollDTO.profilePic;
        this.departments = employeePayrollDTO.department;
    }

}
