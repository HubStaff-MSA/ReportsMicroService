package com.reportsMicroservice.demo.model.reports;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class TimeAndActivityReport {
    private String project;
    private String member;
    private double regularHours;
    private double overtime;
    private double totalHours;
    private double manualHours;
    private double totalSpent;
    private double regularSpent;
}
