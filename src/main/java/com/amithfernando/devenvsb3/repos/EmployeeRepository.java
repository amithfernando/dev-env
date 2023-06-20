package com.amithfernando.devenvsb3.repos;

import com.amithfernando.devenvsb3.models.Employee;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends CrudRepository<Employee,String> {
}
