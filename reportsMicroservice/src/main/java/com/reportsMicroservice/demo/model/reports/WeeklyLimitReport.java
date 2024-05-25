package com.reportsMicroservice.demo.model.reports;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class WeeklyLimitReport {
    @Id
    @GeneratedValue
    private UUID id;
    private Integer userId;
    private String fullName;
    private double totalHoursWorked;
    private double weeklyLimit;
    private double percentageUsed;
    private double remainingHours;
}
