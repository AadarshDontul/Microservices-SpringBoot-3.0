package com.ethane3.employeeservice.model;

public record Employee(Long id, Long departmentId, String name, int age, String position) {
}
