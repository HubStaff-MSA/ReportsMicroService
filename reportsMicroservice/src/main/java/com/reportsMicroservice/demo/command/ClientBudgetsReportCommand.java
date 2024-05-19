package com.reportsMicroservice.demo.command;


import com.reportsMicroservice.demo.model.reports.ClientBudgetsReport;
import com.reportsMicroservice.demo.service.reports.ClientBudgetsReportService;

import java.util.List;

public class ClientBudgetsReportCommand implements Command {
    private ClientBudgetsReportService service;
    private Integer clientId;

    public ClientBudgetsReportCommand(ClientBudgetsReportService service) {
        this.service = service;
        this.clientId = clientId;
    }

    @Override
    public void execute() {
        List<ClientBudgetsReport> reports = service.generateClientBudgetsReport(clientId);
    }
}
