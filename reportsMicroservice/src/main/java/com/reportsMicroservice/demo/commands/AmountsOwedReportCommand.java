package com.reportsMicroservice.demo.commands;

import com.reportsMicroservice.demo.dto.TrackTimeDTO;
import com.reportsMicroservice.demo.dto.UserDTO;
import com.reportsMicroservice.demo.service.reports.ReportsService;

import java.util.List;

public class AmountsOwedReportCommand implements Command {
    private ReportsService reportsService;
    private UserDTO user;
    private List<TrackTimeDTO> timesheets;

    public AmountsOwedReportCommand(ReportsService reportsService, UserDTO user, List<TrackTimeDTO> timesheets) {
        this.reportsService = reportsService;
        this.user = user;
        this.timesheets = timesheets;
    }

    @Override
    public void execute() {
        reportsService.generateAmountsOwedReport(user, timesheets);
    }
}
