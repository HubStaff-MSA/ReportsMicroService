package com.reportsMicroservice.demo.repository.reports;

import com.reportsMicroservice.demo.model.reports.WeeklyLimitReport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface WeeklyLimitReportRepository extends JpaRepository<WeeklyLimitReport, UUID> {
}