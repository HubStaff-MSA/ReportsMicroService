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
	public CommandLineRunner commandLineRunner(
			EmployeeRepository employeeRepository
	){
		return args -> {
			var employee = Employee.builder()
					.firstName("fname")
					.lastName("lname")
					.email("emailText")
					.address("addressText")
					.phoneNumber("011100")
					.hireDate(LocalDate.of(2021, 1, 1))
					.build();
			employeeRepository.save(employee);

		};

	}



}
