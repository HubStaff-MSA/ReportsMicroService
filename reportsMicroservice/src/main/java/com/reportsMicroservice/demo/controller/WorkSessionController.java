package com.reportsMicroservice.demo.controller;

import com.reportsMicroservice.demo.model.WorkSessionReport;
import com.reportsMicroservice.demo.service.WorkSessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/reports/work-sessions")
public class WorkSessionController {
    @Autowired
    private WorkSessionService workSessionService;

    // Endpoint to get work sessions by employee ID
    @GetMapping("/employee/{employeeId}")
    public ResponseEntity<List<WorkSessionReport>> getWorkSessionsByEmployeeId(@PathVariable Long employeeId) {
        List<WorkSessionReport> workSessions = workSessionService.getWorkSessionsByEmployeeId(employeeId);
        return ResponseEntity.ok(workSessions);
    }
}
