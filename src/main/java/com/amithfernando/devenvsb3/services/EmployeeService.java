package com.amithfernando.devenvsb3.services;

import com.amithfernando.devenvsb3.dtos.CreateEmployeeRecord;
import com.amithfernando.devenvsb3.dtos.EmployeeRecord;
import com.amithfernando.devenvsb3.models.Employee;
import com.amithfernando.devenvsb3.repos.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public List<EmployeeRecord> getAllEmployees(){
        Iterable<Employee> employees = employeeRepository.findAll();
        List<EmployeeRecord> employeeRecords = StreamSupport.stream(employees.spliterator(), false)
                .map(e -> new EmployeeRecord(e.getId(), e.getFirstName(), e.getLastName()))
                .collect(Collectors.toList());
        return employeeRecords;
    }

    public EmployeeRecord createEmployee(CreateEmployeeRecord createEmployeeRecord) {
        String id = UUID.randomUUID().toString();
        Employee employee = Employee.builder()
                .id(id)
                .firstName(createEmployeeRecord.firstName())
                .lastName(createEmployeeRecord.lastName())
                .build();
        employeeRepository.save(employee);

        return new EmployeeRecord(employee.getId(),employee.getFirstName(),employee.getLastName());

    }
}
