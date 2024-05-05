package com.reportsMicroservice.demo.controller;

import com.reportsMicroservice.demo.model.WorkSessionReport;
import com.reportsMicroservice.demo.service.WorkSessionReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/reports")
public class ReportsController {

    @Autowired
    private WorkSessionReportService workSessionReportService;

    @GetMapping("/work-sessions")
    public ResponseEntity<List<WorkSessionReport>> getWorkSessionReports() {
        List<WorkSessionReport> reports = workSessionReportService.generateReport();
        return ResponseEntity.ok(reports);
    }

    // Other report endpoints can be added here
}

