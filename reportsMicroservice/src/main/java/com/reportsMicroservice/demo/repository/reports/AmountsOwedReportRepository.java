package com.reportsMicroservice.demo.repository.reports;

import com.reportsMicroservice.demo.model.reports.AmountsOwedReport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AmountsOwedReportRepository extends JpaRepository<AmountsOwedReport, Long> {
}
