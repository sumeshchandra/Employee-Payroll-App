package com.example.employeepayrollapp.controller;

import com.example.employeepayrollapp.dto.EmployeePayrollDTO;
import com.example.employeepayrollapp.dto.ResponseDTO;
import com.example.employeepayrollapp.model.EmployeePayrollData;
import com.example.employeepayrollapp.service.IEmployeePayrollService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * @author sumesh jena
 * @version 0.0.1
 * @since 10-10-2021
 */

@Slf4j
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
        List<EmployeePayrollData> empDataList ;
        empDataList = employeePayrollService.getEmployeePayrollData();
        ResponseDTO responseDTO = new ResponseDTO("Get Call Success", empDataList);
        log.info("get all data");
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);

    }

    /**
     * @param id get employee detail with id
     * @return details added
     */
    @GetMapping("/get/{id}")
    public ResponseEntity<ResponseDTO> getEmployeePayrollData(@Valid @PathVariable("id") int id) {
        EmployeePayrollData empData = employeePayrollService.getEmployeePayrollDataById(id);
        ResponseDTO responseDTO = new ResponseDTO("Get Call Success Id", empData);
        log.info("get success for Id");
        return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
    }

    /**
     * @param employeePayrollDTO
     * @return
     */
    @PostMapping("/create")
    public ResponseEntity<ResponseDTO> createEmployeePayrollData( @RequestBody EmployeePayrollDTO employeePayrollDTO) {
        EmployeePayrollData empData = null;
        empData = employeePayrollService.createEmployeePayrollData(employeePayrollDTO);
        ResponseDTO responseDto = new ResponseDTO("Created Employee Payroll Data Succesfully ", empData);
        log.info("Created Data");
        return new ResponseEntity<ResponseDTO>(responseDto, HttpStatus.OK);
    }

    /**
     * @param employeePayrollDTO
     * @return updated value
     */
    @PutMapping("/update/{Id}")
    public ResponseEntity<ResponseDTO> updateEmployeePayroll(@PathVariable("Id") int Id,@Valid @RequestBody EmployeePayrollDTO employeePayrollDTO) {
        EmployeePayrollData empData = employeePayrollService.updateEmployeePayrollData(Id, employeePayrollDTO);
        ResponseDTO responseDTO = new ResponseDTO("Update Employee Payroll Data Successfully", empData);
        log.info("Updated Data ");
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<ResponseDTO> deleteEmployeePayroll(@PathVariable(value = "id") int id) {
        employeePayrollService.deleteEmployeePayrollData(id);
        ResponseDTO responseDto = new ResponseDTO("Deleted Successfully", "deleted id : " + id);
        log.info("Deleted Data");
        return new ResponseEntity<>(responseDto, HttpStatus.OK);
    }

}













