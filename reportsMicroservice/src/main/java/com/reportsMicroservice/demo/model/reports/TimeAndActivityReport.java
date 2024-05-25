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
