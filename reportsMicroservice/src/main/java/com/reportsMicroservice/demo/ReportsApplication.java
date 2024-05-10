package com.reportsMicroservice.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ReportsApplication {

    public static void main(String[] args) {

        SpringApplication.run(ReportsApplication.class, args);

//        ReportsMiniService reportsMiniService = new ReportsMiniService();
//
//        //worksession report
//        WorkSessionReportService worksessionReportService = new WorkSessionReportService();
//        reportsMiniService.generateWorksessionReport(worksessionReportService);
//
//        //client budgets report
//        ClientBudgetsReportService clientBudgetsReportService = new ClientBudgetsReportService();
//        reportsMiniService.generateClientBudgetsReport(clientBudgetsReportService);
//
//        //project budgets report
//        ProjectBudgetsReportService projectBudgetsReportService = new ProjectBudgetsReportService();
//        reportsMiniService.generateProjectBudgetsReport(projectBudgetsReportService);
//
//        //payments report
//        PaymentsReportService paymentsReportService = new PaymentsReportService();
//        reportsMiniService.generatePaymentsReport(paymentsReportService);
//
//        //weekly limit report
//        WeeklyLimitReportService weeklyLimitReportService = new WeeklyLimitReportService();
//        reportsMiniService.generateWeeklyLimitReport(weeklyLimitReportService);
//
//        //amounts owed report
//        AmountsOwedReportService amountsOwedReportService = new AmountsOwedReportService();
//        reportsMiniService.generateAmountsOwedReport(amountsOwedReportService);

    }
}
