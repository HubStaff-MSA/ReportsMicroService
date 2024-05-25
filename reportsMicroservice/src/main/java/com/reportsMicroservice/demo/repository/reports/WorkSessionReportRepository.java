package com.reportsMicroservice.demo.repository.reports;

import com.reportsMicroservice.demo.model.reports.WorkSessionReport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface WorkSessionReportRepository extends JpaRepository<WorkSessionReport, UUID> {
}