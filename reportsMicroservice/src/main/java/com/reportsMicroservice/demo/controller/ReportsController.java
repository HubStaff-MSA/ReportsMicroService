package com.reportsMicroservice.demo.controller;

import org.springframework.http.ResponseEntity;
import com.reportsMicroservice.demo.dto.*;
import com.reportsMicroservice.demo.model.reports.*;
import com.reportsMicroservice.demo.repository.reports.*;
import com.reportsMicroservice.demo.service.reports.ReportsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController
@RequestMapping("/api/reports")
public class ReportsController {
    @Autowired
    private ReportsService reportsService;

    @Autowired
    private WorkSessionReportRepository workSessionReportRepository;

    @Autowired
    private TimeAndActivityReportRepository timeAndActivityReportRepository;

    @Autowired
    private WeeklyLimitReportRepository weeklyLimitReportRepository;

    @Autowired
    private ProjectBudgetsReportRepository projectBudgetsReportRepository;

    @Autowired
    private ClientBudgetsReportRepository clientBudgetsReportRepository;

    @Autowired
    private PaymentsReportRepository paymentsReportRepository;

    @Autowired
    private AmountsOwedReportRepository amountsOwedReportRepository;
    @GetMapping("/test")
    public ResponseEntity<String> testApi() {
        return ResponseEntity.ok("API is working");
    }

    @GetMapping("/work-session-report/{userId}")
    public ResponseEntity<List<WorkSessionReport>> getWorkSessionReport(@PathVariable Long userId) {
        List<WorkSessionReport> reports = workSessionReportRepository.findByUserId(userId);
        if (reports.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(reports);
    }






}

