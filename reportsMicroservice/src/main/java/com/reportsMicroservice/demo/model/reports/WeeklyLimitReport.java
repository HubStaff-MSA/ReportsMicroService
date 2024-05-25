package com.reportsMicroservice.demo.model.reports;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class WeeklyLimitReport {
    private Integer userId;
    private String fullName;
    private double totalHoursWorked;
    private double weeklyLimit;
    private double percentageUsed;
    private double remainingHours;
}
