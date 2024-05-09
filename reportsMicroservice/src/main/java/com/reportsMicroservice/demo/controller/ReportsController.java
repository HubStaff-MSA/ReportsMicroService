package com.reportsMicroservice.demo.controller;

import com.reportsMicroservice.demo.model.reports.*;
import com.reportsMicroservice.demo.service.reports.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/reports")
public class ReportsController {

    @Autowired
    private WorkSessionReportService workSessionReportService;

    @Autowired
    private AmountsOwedReportService amountsOwedReportService;

    @Autowired
    private ClientBudgetsReportService clientBudgetsReportService;

    @Autowired
    private ProjectBudgetsReportService projectBudgetsReportService;

    @Autowired
    private PaymentsReportService paymentsReportService;

    @GetMapping("/worksession/user/{userId}")  // Changed from @PostMapping to @GetMapping
    public ResponseEntity<WorkSessionReport> getWorkSessionReportByUserId(@PathVariable Integer userId) {
        try {
            WorkSessionReport report = workSessionReportService.generateWorkSessionReportByUserId(userId);
            return ResponseEntity.ok(report);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.notFound().build();  // Handling case where user or report is not found
        }
    }

    @GetMapping("/amounts-owed")
    public ResponseEntity<List<AmountsOwedReport>> getAmountsOwedReport(
            @RequestParam(name = "from") String fromDate,
            @RequestParam(name = "to") String toDate) {

        try {
            LocalDate from = LocalDate.parse(fromDate);
            LocalDate to = LocalDate.parse(toDate);

            List<AmountsOwedReport> report = amountsOwedReportService.generateAmountsOwedReport(from, to);
            return ResponseEntity.ok(report);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().build(); // Handle invalid date format
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build(); // Handle unexpected errors
        }
    }

    @GetMapping("/client-budgets")
    public ResponseEntity<List<ClientBudgetsReport>> getClientBudgetsReport() {
        try {
            List<ClientBudgetsReport> report = clientBudgetsReportService.generateClientBudgetsReport();
            return ResponseEntity.ok(report);
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build(); // Handle unexpected errors
        }
    }

    @GetMapping("/project-budgets")
    public ResponseEntity<List<ProjectBudgetsReport>> getProjectBudgetsReport() {
        try {
            List<ProjectBudgetsReport> report = projectBudgetsReportService.generateProjectBudgetsReport();
            return ResponseEntity.ok(report);
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build(); // Handle unexpected errors
        }
    }

    @GetMapping("/payments")
    public ResponseEntity<List<PaymentsReport>> getPaymentsReport(
            @RequestParam("from") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate fromDate,
            @RequestParam("to") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate toDate) {
        try {
            List<PaymentsReport> report = paymentsReportService.generatePaymentsReport(fromDate, toDate);
            return ResponseEntity.ok(report);
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build(); // Handle unexpected errors
        }
    }










}

