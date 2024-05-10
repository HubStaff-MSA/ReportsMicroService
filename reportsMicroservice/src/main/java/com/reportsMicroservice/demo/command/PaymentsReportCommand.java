package com.reportsMicroservice.demo.command;


import com.reportsMicroservice.demo.model.reports.PaymentsReport;
import com.reportsMicroservice.demo.service.reports.PaymentsReportService;

import java.util.List;

public class PaymentsReportCommand implements Command {
    private PaymentsReportService service;

    public PaymentsReportCommand(PaymentsReportService service) {
        this.service = service;
    }

    @Override
    public void execute() {
        List<PaymentsReport> reports = service.generatePaymentsReport();
    }
}
