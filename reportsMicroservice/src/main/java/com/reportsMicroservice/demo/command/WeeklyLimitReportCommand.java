package com.reportsMicroservice.demo.command;

import com.reportsMicroservice.demo.model.reports.WeeklyLimitReport;
import com.reportsMicroservice.demo.service.reports.WeeklyLimitReportService;

import java.util.List;

public class WeeklyLimitReportCommand implements Command {
    private WeeklyLimitReportService service;
    private Integer userId;

    public WeeklyLimitReportCommand(WeeklyLimitReportService service) {
        this.service = service;
        this.userId = userId;
    }

    @Override
    public void execute() {
        List<WeeklyLimitReport> reports = service.generateWeeklyLimitReport(userId);
    }
}

