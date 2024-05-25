package com.reportsMicroservice.demo.commands;

import com.reportsMicroservice.demo.dto.PaymentDTO;
import com.reportsMicroservice.demo.dto.ProjectDTO;
import com.reportsMicroservice.demo.dto.TrackTimeDTO;
import com.reportsMicroservice.demo.dto.UserDTO;
import com.reportsMicroservice.demo.service.reports.ReportsService;

import java.util.List;

public class TimeAndActivityReportCommand implements Command {
    private ReportsService reportsService;
    private UserDTO user;
    private List<ProjectDTO> projects;
    private List<TrackTimeDTO> timesheets;
    private List<PaymentDTO> payments;

    public TimeAndActivityReportCommand(ReportsService reportsService, UserDTO user, List<ProjectDTO> projects, List<TrackTimeDTO> timesheets, List<PaymentDTO> payments) {
        this.reportsService = reportsService;
        this.user = user;
        this.projects = projects;
        this.timesheets = timesheets;
        this.payments = payments;
    }

    @Override
    public void execute() {
        reportsService.generateTimeAndActivityReports(user, projects, timesheets, payments);
    }
}
