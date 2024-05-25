package com.reportsMicroservice.demo.commands;

import com.reportsMicroservice.demo.dto.PaymentDTO;
import com.reportsMicroservice.demo.dto.PMtoReportsProjectDTO;
import com.reportsMicroservice.demo.service.reports.ReportsService;

import java.util.List;

public class ProjectBudgetsReportCommand implements Command {
    private ReportsService reportsService;
    private PMtoReportsProjectDTO project;
    private List<PaymentDTO> payments;

    public ProjectBudgetsReportCommand(ReportsService reportsService, PMtoReportsProjectDTO project, List<PaymentDTO> payments) {
        this.reportsService = reportsService;
        this.project = project;
        this.payments = payments;
    }

    @Override
    public void execute() {
        reportsService.generateProjectBudgetsReport(project, payments);
    }
}
