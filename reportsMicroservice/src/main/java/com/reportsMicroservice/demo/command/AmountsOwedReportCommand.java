package com.reportsMicroservice.demo.command;


import com.reportsMicroservice.demo.model.reports.AmountsOwedReport;
import com.reportsMicroservice.demo.service.reports.AmountsOwedReportService;

import java.util.List;

public class AmountsOwedReportCommand implements Command {
    private AmountsOwedReportService service;

    public AmountsOwedReportCommand(AmountsOwedReportService service) {
        this.service = service;
    }

    @Override
    public void execute() {
        List<AmountsOwedReport> reports = service.generateAmountsOwedReport();
    }

}
