package com.reportsMicroservice.demo.controller;

import com.reportsMicroservice.demo.model.reports.*;
import com.reportsMicroservice.demo.service.reports.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/reports")
public class ReportsController {

    @Autowired
    private WorkSessionReportService workSessionReportService;

    @Autowired
    private TimeOffTransactionReportService timeoffTransactionReportService;

    @Autowired
    private TimeOffBalancesReportService timeoffBalancesReportService;

    @Autowired
    private AmountsOwedReportService amountsOwedReportService;

    @Autowired
    private ClientBudgetsReportService clientBudgetsReportService;

    @Autowired
    private ProjectBudgetsReportService projectBudgetsReportService;

    @Autowired
    private PaymentsReportService paymentsReportService;

    @Autowired
    private WeeklyLimitReportService WeeklyLimitReportService;



    @GetMapping("/worksession")
    public ResponseEntity<List<WorkSessionReport>> getAllWorkSessionReports() {
        List<WorkSessionReport> reportList = workSessionReportService.generateWorkSessionReports();
        if (reportList.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(reportList);
    }

    @GetMapping("/timeofftransaction")
    public ResponseEntity<List<TimeOffTransactionReport>> getAllTimeOffTransactionReports() {
        List<TimeOffTransactionReport> reportList = timeoffTransactionReportService.generateTimeOffTransactionReports();
        if (reportList.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(reportList);
    }

    @GetMapping("/timeoffbalances")
    public ResponseEntity<List<TimeOffBalancesReport>> getAllTimeOffBalancesReports() {
        List<TimeOffBalancesReport> reportList = timeoffBalancesReportService.generateTimeOffTransactionReports();
        if (reportList.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(reportList);
    }

    @GetMapping("/amounts-owed")
    public ResponseEntity<List<AmountsOwedReport>> getAmountsOwedReport() {
        try {
            List<AmountsOwedReport> report = amountsOwedReportService.generateAmountsOwedReport();
            return ResponseEntity.ok(report);
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }

    @GetMapping("/client-budgets")
    public ResponseEntity<List<ClientBudgetsReport>> getClientBudgetsReport() {
        try {
            List<ClientBudgetsReport> report = clientBudgetsReportService.generateClientBudgetsReport();
            return ResponseEntity.ok(report);
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }

    @GetMapping("/project-budgets")
    public ResponseEntity<List<ProjectBudgetsReport>> getProjectBudgetsReport() {
        try {
            List<ProjectBudgetsReport> report = projectBudgetsReportService.generateProjectBudgetsReport();
            return ResponseEntity.ok(report);
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }

    @GetMapping("/payments")
    public ResponseEntity<List<PaymentsReport>> getPaymentsReport() {
        try {
            List<PaymentsReport> report = paymentsReportService.generatePaymentsReport();
            return ResponseEntity.ok(report);
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }

    @GetMapping("/weekly-limit")
    public ResponseEntity<List<WeeklyLimitReport>> getWeeklyLimitReport() {
        try {
            List<WeeklyLimitReport> weeklyLimitReportList = WeeklyLimitReportService.generateWeeklyLimitReport();
            return ResponseEntity.ok(weeklyLimitReportList);
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }


}

