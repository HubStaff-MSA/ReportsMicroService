package com.reportsMicroservice.demo.repository.reports;

import com.reportsMicroservice.demo.model.reports.ClientBudgetsReport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ClientBudgetsReportRepository extends JpaRepository<ClientBudgetsReport, UUID> {
}