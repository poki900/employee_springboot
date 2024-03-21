package com.lab.lab5.service;

import com.lab.lab5.entity.Employee;

import java.util.List;

public interface EmployeeService {
    void addEmployee(Employee employee);

    List<Employee> getEmployees();

    Employee getEmployee(Integer id);

    void deleteEmployee(Integer id);

    void getEmployeesCSV();
}
