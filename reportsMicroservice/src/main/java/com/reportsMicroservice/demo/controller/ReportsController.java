package com.reportsMicroservice.demo.controller;

import com.reportsMicroservice.demo.commands.WeeklyLimitTest;
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
    private WeeklyLimitTest weeklyLimitTest;

    @GetMapping("/work-limit-report/{userId}")
    public ResponseEntity<WeeklyLimitReport> getWeeklyLimitReport(@PathVariable Integer userId) {
        weeklyLimitTest.setUserId(userId);
        weeklyLimitTest.execute();
        System.out.println("###################################");
        return ResponseEntity.ok().build();
    }








}

