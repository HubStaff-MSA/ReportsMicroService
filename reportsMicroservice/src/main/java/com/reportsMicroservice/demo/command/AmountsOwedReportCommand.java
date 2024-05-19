package com.reportsMicroservice.demo.command;


import com.reportsMicroservice.demo.model.reports.AmountsOwedReport;
import com.reportsMicroservice.demo.service.reports.AmountsOwedReportService;

import java.util.List;

public class AmountsOwedReportCommand implements Command {
    private AmountsOwedReportService service;
    private Integer userId;

    public AmountsOwedReportCommand(AmountsOwedReportService service, Integer userId) {
        this.service = service;
        this.userId= userId;
    }

    @Override
    public void execute() {
        List<AmountsOwedReport> reports = service.generateAmountsOwedReport(userId);
        reports.forEach(report -> System.out.println(report));
    }

}
