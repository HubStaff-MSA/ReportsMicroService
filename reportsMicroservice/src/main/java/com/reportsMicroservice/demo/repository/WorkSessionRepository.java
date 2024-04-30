package com.reportsMicroservice.demo.repository;

import com.reportsMicroservice.demo.model.WorkSessionReport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WorkSessionRepository extends JpaRepository<WorkSessionReport, Long> {

    // Define custom queries as needed
    // Example: Find work sessions by employee ID
    List<WorkSessionReport> findByEmployeeId(Long employeeId);
}
