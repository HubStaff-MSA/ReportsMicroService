package com.reportsMicroservice.demo.controller;

import com.reportsMicroservice.demo.model.reports.*;
import com.reportsMicroservice.demo.service.reports.*;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.logging.Logger;

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
    private ShiftAttendanceReportService shiftAttendanceReportService;

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

    @GetMapping("/worksession/{userID}")
    public ResponseEntity<List<WorkSessionReport>> getAllWorkSessionReports(@PathVariable("userID") Integer userID) {
        List<WorkSessionReport> reportList = workSessionReportService.generateWorkSessionReports(userID);
        if (reportList.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(reportList);
    }

    @GetMapping("/timeofftransaction/{userID}")
    public ResponseEntity<List<TimeOffTransactionReport>> getAllTimeOffTransactionReports() {
        List<TimeOffTransactionReport> reportList = timeoffTransactionReportService.generateTimeOffTransactionReports();
        if (reportList.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(reportList);
    }

    @GetMapping("/timeoffbalances/{userID}")
    public ResponseEntity<List<TimeOffBalancesReport>> getAllTimeOffBalancesReports() {
        List<TimeOffBalancesReport> reportList = timeoffBalancesReportService.generateTimeOffTransactionReports();
        if (reportList.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(reportList);
    }

    @GetMapping("/amounts-owed/{userID}")
    public ResponseEntity<List<AmountsOwedReport>> getAmountsOwedReport(@PathVariable("userID") Integer userID) {
        try {
            List<AmountsOwedReport> report = amountsOwedReportService.generateAmountsOwedReport(userID);
            if (report.isEmpty()) {
                return ResponseEntity.notFound().build();
            }
            return ResponseEntity.ok(report);
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }

    @GetMapping("/client-budgets/{clientID}")
    public ResponseEntity<List<ClientBudgetsReport>> getClientBudgetsReport(@PathVariable("clientID") Integer clientID) {
        try {
            List<ClientBudgetsReport> report = clientBudgetsReportService.generateClientBudgetsReport(clientID);
            if (report.isEmpty()) {
                return ResponseEntity.notFound().build();  // No report found for the client
            }
            return ResponseEntity.ok(report);
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }

    @GetMapping("/project-budgets/{projectID}")
    public ResponseEntity<List<ProjectBudgetsReport>> getProjectBudgetsReport(@PathVariable("projectID") Integer projectID) {
        try {
            List<ProjectBudgetsReport> report = projectBudgetsReportService.generateProjectBudgetsReport(projectID);
            if (report.isEmpty()) {
                return ResponseEntity.notFound().build();  // No report found for the project
            }
            return ResponseEntity.ok(report);
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }

    @GetMapping("/payments/{userID}")
    public ResponseEntity<List<PaymentsReport>> getPaymentsReport(@PathVariable("userID") Integer userID) {
        try {
            List<PaymentsReport> report = paymentsReportService.generatePaymentsReport(userID);
            if (report.isEmpty()) {
                return ResponseEntity.notFound().build();  // No report found for the user
            }
            return ResponseEntity.ok(report);
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }

    @GetMapping("/weekly-limit/{userID}")
    public ResponseEntity<List<WeeklyLimitReport>> getWeeklyLimitReport(@PathVariable Integer userID) {
        List<WeeklyLimitReport> report = WeeklyLimitReportService.generateWeeklyLimitReport(userID);
        if (report.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(report);
    }

    //    @GetMapping("/shiftattendance")
//    public ResponseEntity<List<ShiftAttendanceReport>> getAllshiftAttendanceReports() {
//        List<ShiftAttendanceReport> reportList = shiftAttendanceReportService.generateShiftAttendanceReports();
//        if (reportList.isEmpty()) {
//            return ResponseEntity.notFound().build();
//        }
//        return ResponseEntity.ok(reportList);
//    }


}

