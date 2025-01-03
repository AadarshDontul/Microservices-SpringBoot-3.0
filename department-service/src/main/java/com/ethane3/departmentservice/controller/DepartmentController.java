package com.ethane3.departmentservice.controller;

import com.ethane3.departmentservice.client.EmployeeClient;
import com.ethane3.departmentservice.model.Department;
import com.ethane3.departmentservice.repository.DepartmentRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/department")
public class DepartmentController {

    private static final Logger LOGGER =
            LoggerFactory.getLogger(DepartmentController.class);

    private DepartmentRepository departmentRepository;

    public DepartmentController(DepartmentRepository departmentRepository){
        this.departmentRepository = departmentRepository;
    }

    @PostMapping
    public Department add(@RequestBody Department department){
        LOGGER.info("Department add:{}",department);
        return departmentRepository.addDepartment(department);
    }

    @GetMapping
    public List<Department> findAll(){
        LOGGER.info("Department find");
        return departmentRepository.findAll();
    }

    @GetMapping("/{id}")
    public Department findById(@PathVariable Long id){
        LOGGER.info("Department find :{}",id);
        return departmentRepository.findById(id);
    }

    @Autowired
    private EmployeeClient employeeClient;

    @GetMapping("/with-employees")
    public List<Department> findAllWithEmployees(){
        LOGGER.info("Department find with-employees");
        List<Department> departments = departmentRepository.findAll();
        departments.forEach(department -> department.setEmployeeList(
                employeeClient.getEmployeeByDepartment(department.getId())
        ));

        return departments;
    }

}
