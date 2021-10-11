package com.example.employeepayrollapp.entity;

import lombok.Data;
import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@Entity
public class EmployeeEntity {
    @Id
    private int id;
    private String name;
    private int salary;

}
