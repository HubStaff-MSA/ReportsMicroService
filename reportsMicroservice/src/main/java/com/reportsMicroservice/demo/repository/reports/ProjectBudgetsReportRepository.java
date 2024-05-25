package com.reportsMicroservice.demo.repository.reports;

import com.reportsMicroservice.demo.model.reports.ProjectBudgetsReport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjectBudgetsReportRepository extends JpaRepository<ProjectBudgetsReport, Long> {
}
