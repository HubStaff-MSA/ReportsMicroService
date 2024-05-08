package com.reportsMicroservice.demo.controller;
import com.reportsMicroservice.demo.model.Timesheet_time;
import com.reportsMicroservice.demo.service.Timesheet_timeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/timesheet_time")

public class Timesheet_timeController {
    @Autowired
    private Timesheet_timeService timesheet_timeService;

    @GetMapping
    public ResponseEntity<List<Timesheet_time>> getAllTimesheet_times() {
        List<Timesheet_time> timesheet_times = timesheet_timeService.getAllTimesheet_times();
        return ResponseEntity.ok(timesheet_times);
    }

    @GetMapping("/{timesheet_timeId}")
    public ResponseEntity<Timesheet_time> getTimesheet_timeById(@PathVariable Integer timesheet_timeId) {
        return timesheet_timeService.getTimesheet_timeById(timesheet_timeId)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Timesheet_time> createTimesheet_time(@RequestBody Timesheet_time timesheet_time) {
        Timesheet_time savedTimesheet_time = timesheet_timeService.saveTimesheet_time(timesheet_time);
        return new ResponseEntity<>(savedTimesheet_time, HttpStatus.CREATED);
    }

    @DeleteMapping("/{timesheet_timeId}")
    public ResponseEntity<Void> deleteTimesheet_time(@PathVariable Integer timesheet_timeId) {
        timesheet_timeService.deleteTimesheet_time(timesheet_timeId);
        return ResponseEntity.noContent().build();
    }
}
