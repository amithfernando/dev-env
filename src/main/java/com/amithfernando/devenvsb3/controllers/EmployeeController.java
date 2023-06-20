package com.amithfernando.devenvsb3.controllers;

import com.amithfernando.devenvsb3.dtos.CreateEmployeeRecord;
import com.amithfernando.devenvsb3.dtos.EmployeeRecord;
import com.amithfernando.devenvsb3.services.EmployeeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Slf4j
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/employees")
    public List<EmployeeRecord> getAllEmployees(){
        log.info("getAllEmployees called");
        return employeeService.getAllEmployees();
    }

    @PostMapping("/employees")
    public EmployeeRecord createEmployee(@RequestBody  CreateEmployeeRecord createEmployeeRecord){
        log.info("createEmployee called");
        return employeeService.createEmployee(createEmployeeRecord);
    }

}
