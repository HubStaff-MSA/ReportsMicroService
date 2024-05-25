package com.reportsMicroservice.demo.model.reports;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalTime;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ShiftAttendanceReport {
    private String member;
    //private Shift.IssueStatus issue;
    private String shift;
    private LocalTime startTime;
    private double requiredHrs;
    private double actualHrs;
}
