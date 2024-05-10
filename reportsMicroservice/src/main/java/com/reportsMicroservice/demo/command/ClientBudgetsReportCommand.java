package com.reportsMicroservice.demo.command;


import com.reportsMicroservice.demo.model.reports.ClientBudgetsReport;
import com.reportsMicroservice.demo.service.reports.ClientBudgetsReportService;

import java.util.List;

public class ClientBudgetsReportCommand implements Command {
    private ClientBudgetsReportService service;

    public ClientBudgetsReportCommand(ClientBudgetsReportService service) {
        this.service = service;
    }

    @Override
    public void execute() {
        List<ClientBudgetsReport> reports = service.generateClientBudgetsReport();
    }
}
