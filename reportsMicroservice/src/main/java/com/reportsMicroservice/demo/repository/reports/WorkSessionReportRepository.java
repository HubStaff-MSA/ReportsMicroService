package com.reportsMicroservice.demo.repository.reports;

import com.reportsMicroservice.demo.model.reports.WorkSessionReport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WorkSessionReportRepository extends JpaRepository<WorkSessionReport, Long> {
    List<WorkSessionReport> findByUserId(Long userId);


}