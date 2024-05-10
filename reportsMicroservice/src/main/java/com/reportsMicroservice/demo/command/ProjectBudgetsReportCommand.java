package com.reportsMicroservice.demo.command;


import com.reportsMicroservice.demo.model.reports.ProjectBudgetsReport;
import com.reportsMicroservice.demo.service.reports.ProjectBudgetsReportService;

import java.util.List;

public class ProjectBudgetsReportCommand implements Command {
    private ProjectBudgetsReportService service;

    public ProjectBudgetsReportCommand(ProjectBudgetsReportService service) {
        this.service = service;
    }

    @Override
    public void execute() {
        List<ProjectBudgetsReport> reports = service.generateProjectBudgetsReport();
    }

}
