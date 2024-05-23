package com.reportsMicroservice.demo.model.reports;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalTime;

@Getter
@Setter
@AllArgsConstructor
public class ShiftAttendanceReport {
    private String member;
    //private Shift.IssueStatus issue;
    private String shift;
    private LocalTime startTime;
    private double requiredHrs;
    private double actualHrs;
}
