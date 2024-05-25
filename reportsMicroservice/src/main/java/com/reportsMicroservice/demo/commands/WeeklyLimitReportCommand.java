package com.reportsMicroservice.demo.commands;

import com.reportsMicroservice.demo.dto.UserDTO;
import com.reportsMicroservice.demo.service.reports.ReportsService;

public class WeeklyLimitReportCommand implements Command {
    private ReportsService reportsService;
    private UserDTO user;

    public WeeklyLimitReportCommand(ReportsService reportsService, UserDTO user) {
        this.reportsService = reportsService;
        this.user = user;
    }

    @Override
    public void execute() {
        reportsService.generateWeeklyLimitReport(user);
    }
}
