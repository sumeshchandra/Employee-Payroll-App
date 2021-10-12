package com.example.employeepayrollapp.controller;

import com.example.employeepayrollapp.dto.EmployeePayrollDTO;
import com.example.employeepayrollapp.dto.ResponseDTO;
import com.example.employeepayrollapp.entity.EmployeeEntity;
import com.example.employeepayrollapp.model.EmployeePayrollData;
import com.example.employeepayrollapp.service.EmployeePayrollService;
import com.example.employeepayrollapp.service.IEmployeePayrollService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author sumesh jena
 * @version 0.0.1
 * @since 10-10-2021
 */

@RestController
@RequestMapping(value = "/employeepayrollservice")
public class EmployeePayrollController {

    @Autowired
    private IEmployeePayrollService employeePayrollService;

    /**
     * Function to get the data
     *
     * @return List of EmployeePayroll data
     */
    @RequestMapping("/get")
    public ResponseEntity<ResponseDTO> getEmployeePayrollData() {
        List<EmployeePayrollData> empDataList = null;
        empDataList = employeePayrollService.getEmployeePayrollData();
        ResponseDTO responseDTO = new ResponseDTO("Get Call Success", empDataList);
        return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);

    }

    /**
     * @param id get employee detail with id
     * @return details added
     */
    @GetMapping("/get/{id}")
    public ResponseEntity<ResponseDTO> getEmployeePayrollData(@PathVariable("id") int id) {
        EmployeePayrollData empData = null;
        empData = employeePayrollService.getEmployeePayrollDataById(id);
        ResponseDTO responseDTO = new ResponseDTO("Get Call Success Id", empData);
        return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
    }

    /**
     * @param employeePayrollDTO
     * @return
     */
    @PostMapping("/create")
    public ResponseEntity<ResponseDTO> createEmployeePayrollData(@RequestBody EmployeePayrollDTO employeePayrollDTO) {
        EmployeePayrollData empData = null;
        empData = employeePayrollService.createEmployeePayrollData(employeePayrollDTO);
        ResponseDTO responseDto = new ResponseDTO("Created Employee Payroll Data Succesfully ", empData);
        return new ResponseEntity<ResponseDTO>(responseDto, HttpStatus.OK);
    }

    /**
     * @param employeePayrollDTO
     * @return updated value
     */
    @PutMapping("/update")
    public ResponseEntity<ResponseDTO> updateEmployeePayroll(@RequestBody EmployeePayrollDTO employeePayrollDTO) {
        EmployeePayrollData empData = null;
        empData = employeePayrollService.updateEmployeePayrollData(employeePayrollDTO);
        ResponseDTO responseDTO = new ResponseDTO("Update Employee Payroll Data Successfully", empData);
        return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<ResponseDTO> deleteEmployeePayroll(@PathVariable(value = "id") int id) {
        employeePayrollService.deleteEmployeePayrollData(id);
        ResponseDTO responseDto = new ResponseDTO("Deleted Successfully", "deleted id : " + id);
        return new ResponseEntity<ResponseDTO>(responseDto, HttpStatus.OK);
    }

}













