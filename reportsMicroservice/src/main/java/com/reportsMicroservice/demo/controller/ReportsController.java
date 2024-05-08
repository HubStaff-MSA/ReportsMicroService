package com.reportsMicroservice.demo.controller;

import com.reportsMicroservice.demo.model.reports.WorkSessionReport;
import com.reportsMicroservice.demo.service.reports.WorkSessionReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/reports")
public class ReportsController {

    @Autowired
    private WorkSessionReportService workSessionReportService;

    @GetMapping("/worksession/user/{userId}")  // Changed from @PostMapping to @GetMapping
    public ResponseEntity<WorkSessionReport> getWorkSessionReportByUserId(@PathVariable Integer userId) {
        try {
            WorkSessionReport report = workSessionReportService.generateWorkSessionReportByUserId(userId);
            return ResponseEntity.ok(report);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.notFound().build();  // Handling case where user or report is not found
        }
    }
}

