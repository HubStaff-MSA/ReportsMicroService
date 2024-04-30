package com.reportsMicroservice.demo.controller;

import com.reportsMicroservice.demo.model.Employee;
import com.reportsMicroservice.demo.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.reportsMicroservice.demo.service.EmployeeService;

@RestController
@RequestMapping("api/employee")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    EmployeeRepository employeeRepository;

    @GetMapping("getAllEmployees")
    public Iterable<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    @PostMapping
    public Employee addEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }
}
