package com.example.employeepayrollapp.dto;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.sun.istack.NotNull;
import lombok.Data;
import lombok.ToString;

import javax.validation.constraints.*;
import java.time.LocalDate;
import java.util.List;

@Data
@ToString
public class EmployeePayrollDTO {

    @NotNull
    @Pattern(regexp = "^[A-Z]{1}[a-zA-Z]{2,}$", message = "Enter Proper Name")
    public String name;

    @NotNull
    @Min(value = 1000, message = "Salary greater than 1000")
    @Max(value = 10000, message = "salary less than 10000")
    public long salary;

    @NotNull
    @Pattern(regexp = "male|female", message = "male or female")
    @Pattern(regexp = "male|female", message = "male or female")
    public String gender;

    @NotNull
    @JsonFormat(pattern = "dd MMM yyyy")
    @PastOrPresent(message = "Current Date or Past Date")
    public LocalDate startDate;

    @NotBlank
    public String note;

    @NotBlank
    public String profilePic;

    @NotNull
    public List<String> department;


}
