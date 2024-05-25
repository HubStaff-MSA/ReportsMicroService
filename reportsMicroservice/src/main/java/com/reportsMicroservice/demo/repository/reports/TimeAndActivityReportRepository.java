package com.reportsMicroservice.demo.repository.reports;


import com.reportsMicroservice.demo.model.reports.TimeAndActivityReport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TimeAndActivityReportRepository extends JpaRepository<TimeAndActivityReport, Long> {
}