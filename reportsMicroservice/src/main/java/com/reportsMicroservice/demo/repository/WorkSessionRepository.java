package com.reportsMicroservice.demo.repository;

import com.reportsMicroservice.demo.model.WorkSessionReport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WorkSessionRepository extends JpaRepository<WorkSessionReport, Long> {

    // Define custom queries as needed
    // Example: Find work sessions by employee ID
    List<WorkSessionReport> findByMemberId(Long employeeId);
    @Query("SELECT new com.reportsMicroservice.demo.dto.WorkSessionReportDto" +
            "(t.client.name, p.projectName, CONCAT(e.firstName, ' ', e.lastName), " +
            " t.toDo.content, t.manual, t.startTime, t.endTime, t.duration, t.activity)" +
            " FROM WorkSessionReport t " +
            " JOIN t.member e " +
            " JOIN t.project p " +
            " LEFT JOIN t.toDo td " +
            " LEFT JOIN p.client c")
    List<WorkSessionReport> getAllWorkSessionReports();
}
