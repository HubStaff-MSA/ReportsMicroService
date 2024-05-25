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
public class TimeAndActivityReport {
    @Id
    @GeneratedValue
    private UUID id;
    private String project;
    private String member;
    private double regularHours;
    private double overtime;
    private double totalHours;
    private double totalSpent;
    private double regularSpent;
}
