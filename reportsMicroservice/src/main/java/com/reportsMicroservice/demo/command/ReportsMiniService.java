package com.reportsMicroservice.demo.command;

import com.reportsMicroservice.demo.model.reports.WeeklyLimitReport;
import com.reportsMicroservice.demo.service.reports.*;

public class ReportsMiniService {
    private CommandInvoker commandInvoker;

    public ReportsMiniService() {
        this.commandInvoker = new CommandInvoker();
    }

    //Worksession report
    public void generateWorksessionReport(WorkSessionReportService service) {
        WorkSessionReportCommand command = new WorkSessionReportCommand(service);
        commandInvoker.setCommand(command);
        commandInvoker.executeCommand();
    }

    //Client budgets report
    public void generateClientBudgetsReport(ClientBudgetsReportService service) {
        ClientBudgetsReportCommand command = new ClientBudgetsReportCommand(service);
        commandInvoker.setCommand(command);
        commandInvoker.executeCommand();
    }

    //project budgets report
    public void generateProjectBudgetsReport(ProjectBudgetsReportService service) {
        ProjectBudgetsReportCommand command = new ProjectBudgetsReportCommand(service);
        commandInvoker.setCommand(command);
        commandInvoker.executeCommand();
    }

    //payments report
    public void generatePaymentsReport(PaymentsReportService service) {
        PaymentsReportCommand command = new PaymentsReportCommand(service);
        commandInvoker.setCommand(command);
        commandInvoker.executeCommand();
    }

    //weekly limit report
    public void generateWeeklyLimitReport(WeeklyLimitReportService service) {
        WeeklyLimitReportCommand command = new WeeklyLimitReportCommand(service);
        commandInvoker.setCommand(command);
        commandInvoker.executeCommand();
    }

    //amounts owed report
    public void generateAmountsOwedReport(AmountsOwedReportService service) {
        AmountsOwedReportCommand command = new AmountsOwedReportCommand(service);
        commandInvoker.setCommand(command);
        commandInvoker.executeCommand();
    }


}
