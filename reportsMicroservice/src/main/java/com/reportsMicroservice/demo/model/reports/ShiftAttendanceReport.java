package com.reportsMicroservice.demo.model.reports;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalTime;
import java.util.UUID;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ShiftAttendanceReport {
    @Id
    @GeneratedValue
    private UUID id;
    private String member;
    //private Shift.IssueStatus issue;
    private String shift;
    private LocalTime startTime;
    private double requiredHrs;
    private double actualHrs;
}
