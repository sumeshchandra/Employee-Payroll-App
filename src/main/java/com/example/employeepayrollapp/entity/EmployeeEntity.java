package com.example.employeepayrollapp.entity;

import lombok.Data;
import org.springframework.http.HttpStatus;

import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@Entity
public class EmployeeEntity<R> {
    @Id
    private int id;
    private String name;
    private int salary;

    public EmployeeEntity(R responseDTO, HttpStatus ok) {
    }
}
