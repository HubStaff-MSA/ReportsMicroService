package com.reportsMicroservice.demo.repository.reports;

import com.reportsMicroservice.demo.model.reports.PaymentsReport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentsReportRepository extends JpaRepository<PaymentsReport, Long> {
}