package com.reportsMicroservice.demo.commands;

import com.reportsMicroservice.demo.dto.PaymentDTO;
import com.reportsMicroservice.demo.dto.PMtoReportsProjectDTO;
import com.reportsMicroservice.demo.dto.TT_dto;
import com.reportsMicroservice.demo.dto.UserDTO;
import com.reportsMicroservice.demo.service.reports.ReportsService;

import java.util.List;

public class TimeAndActivityReportCommand implements Command {
    private ReportsService reportsService;
    private UserDTO user;
    private List<PMtoReportsProjectDTO> projects;
    private List<TT_dto> timesheets;
    private List<PaymentDTO> payments;

    public TimeAndActivityReportCommand(ReportsService reportsService, UserDTO user, List<PMtoReportsProjectDTO> projects, List<TT_dto> timesheets, List<PaymentDTO> payments) {
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
