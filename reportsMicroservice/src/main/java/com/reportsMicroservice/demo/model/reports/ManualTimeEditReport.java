package com.reportsMicroservice.demo.model.reports;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalTime;

@Getter
@Setter
@AllArgsConstructor
public class ManualTimeEditReport {
    private String member;
    private String about;
    private String project;
    private String todo;
    private String action;
    private String timespan;
    private double timechange;
    private String reason;
    private String changedBy;
    private LocalTime changedAt;
}
