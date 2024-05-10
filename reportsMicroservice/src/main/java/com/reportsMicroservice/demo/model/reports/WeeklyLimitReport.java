package com.reportsMicroservice.demo.model.reports;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class WeeklyLimitReport {
    private Integer userId;
    private String fullName;
    private double totalHoursWorked;
    private double weeklyLimit;
    private double percentageUsed;
    private double remainingHours;
}
