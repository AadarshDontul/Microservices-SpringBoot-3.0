package com.ethane3.employeeservice.repository;

import com.ethane3.employeeservice.model.Employee;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class EmployeeRepository {

    private List<Employee> employees
            = new ArrayList<Employee>();

    public Employee addEmployee(Employee employee) {
        employees.add(employee);
        return employee;
    }

    public List<Employee> getAllEmployees() {
        return employees;
    }

    public Employee findById(Long id) {
        return employees.stream()
                .filter(a-> a.id().equals(id))
                .findFirst()
                .orElseThrow();
    }

    public List<Employee> findByDepartmentId(Long departmentId) {
        return employees.stream()
                .filter(a -> a.departmentId().equals(departmentId))
                .toList();
    }
}
