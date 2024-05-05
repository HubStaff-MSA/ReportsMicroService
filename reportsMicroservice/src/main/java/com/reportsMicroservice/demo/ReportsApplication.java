package com.reportsMicroservice.demo;

import com.reportsMicroservice.demo.repository.EmployeeRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import com.reportsMicroservice.demo.model.Employee;

import java.time.LocalDate;

@SpringBootApplication
public class ReportsApplication {

	public static void main(String[] args) {
		SpringApplication.run(ReportsApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(EmployeeRepository employeeRepository) {
		return args -> {
			Employee employee = new Employee();
			employee.setFirstName("fname");
			employee.setLastName("lname");
			employee.setEmail("emailText");
			employee.setPassword("securePassword123");
			employee.setAddress("addressText");
			employee.setPhoneNumber("011100");
			employee.setHireDate(LocalDate.of(2021, 1, 1));
			employeeRepository.save(employee);
		};

	}



}
