package com.reportsMicroservice.demo.command;


import com.reportsMicroservice.demo.model.reports.PaymentsReport;
import com.reportsMicroservice.demo.service.reports.PaymentsReportService;

import java.util.List;

public class PaymentsReportCommand implements Command {
    private PaymentsReportService service;
    private Integer userId;

    public PaymentsReportCommand(PaymentsReportService service) {
        this.service = service;
        this.userId = userId;
    }

    @Override
    public void execute() {
        List<PaymentsReport> reports = service.generatePaymentsReport(userId);
    }
}
