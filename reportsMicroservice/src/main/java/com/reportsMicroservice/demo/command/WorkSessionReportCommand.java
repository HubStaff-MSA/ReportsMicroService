package com.reportsMicroservice.demo.command;


import com.reportsMicroservice.demo.model.reports.WorkSessionReport;
import com.reportsMicroservice.demo.service.reports.WorkSessionReportService;

import java.util.List;

public class WorkSessionReportCommand implements Command {
    private WorkSessionReportService service;

    public WorkSessionReportCommand(WorkSessionReportService service) {
        this.service = service;
    }

    @Override
    public void execute() {
        List<WorkSessionReport> reports = service.generateWorkSessionReports();
    }
}

