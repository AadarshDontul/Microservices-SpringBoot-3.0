package com.ethane3.employeeservice.controller;

import com.ethane3.employeeservice.model.Employee;
import com.ethane3.employeeservice.repository.EmployeeRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    private static final Logger LOGGER = LoggerFactory.getLogger(EmployeeController.class);

    EmployeeRepository employeeRepository;

    EmployeeController(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @PostMapping
    public Employee add(@RequestBody Employee employee) {
        LOGGER.info("Adding employee: {}", employee);
        return employeeRepository.addEmployee(employee);
    }

    @GetMapping
    public List<Employee> getAllEmployees() {
        LOGGER.info("Getting all employees");
        return employeeRepository.getAllEmployees();
    }

    @GetMapping("/{id}")
    public Employee getEmployeeById(@PathVariable("id") Long id) {
        LOGGER.info("Getting employee by id: {}", id);
        return employeeRepository.findById(id);
    }

    @GetMapping("/department/{departmentId}")
    public List<Employee> getEmployeeByDepartment(@PathVariable("departmentId") Long departmentId) {
        LOGGER.info("Getting employee by department: {}", departmentId);
        return employeeRepository.findByDepartmentId(departmentId);
    }


}
