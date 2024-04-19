package com.reportsMicroservice.demo.service;

import com.reportsMicroservice.demo.model.Employee;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Service
public class EmployeeService {

    @GetMapping
    public List<Employee> getEmployees() {
        return List.of(new Employee(1, "Mariam","Sherif","mariam@gmail","Cairo","011111111", LocalDate.of(2021, Month.JANUARY, 1)),
                new Employee(2, "Ahmed","Ali","ahmed@gmail","Giza","011111112", LocalDate.of(2021, Month.JANUARY, 1)),
                new Employee(3, "Sara","Mohamed","sara@gmail","Alex","011111113", LocalDate.of(2021, Month.JANUARY, 1)));
    }
}
