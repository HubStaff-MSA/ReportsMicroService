package com.reportsMicroservice.demo.command;


import com.reportsMicroservice.demo.model.reports.ProjectBudgetsReport;
import com.reportsMicroservice.demo.service.reports.ProjectBudgetsReportService;

import java.util.List;

public class ProjectBudgetsReportCommand implements Command {
    private ProjectBudgetsReportService service;
    private Integer projectId;

    public ProjectBudgetsReportCommand(ProjectBudgetsReportService service) {
        this.service = service;
        this.projectId = projectId;
    }

    @Override
    public void execute() {
        List<ProjectBudgetsReport> reports = service.generateProjectBudgetsReport(projectId);
    }

}
