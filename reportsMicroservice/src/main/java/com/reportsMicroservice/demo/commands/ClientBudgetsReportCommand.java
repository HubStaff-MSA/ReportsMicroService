package com.reportsMicroservice.demo.commands;

import com.reportsMicroservice.demo.dto.ClientDTO;
import com.reportsMicroservice.demo.dto.PaymentDTO;
import com.reportsMicroservice.demo.service.reports.ReportsService;

import java.util.List;

public class ClientBudgetsReportCommand implements Command {
    private ReportsService reportsService;
    private ClientDTO client;
    private List<PaymentDTO> payments;

    public ClientBudgetsReportCommand(ReportsService reportsService, ClientDTO client, List<PaymentDTO> payments) {
        this.reportsService = reportsService;
        this.client = client;
        this.payments = payments;
    }

    @Override
    public void execute() {
        reportsService.generateClientBudgetsReport(client, payments);
    }
}
