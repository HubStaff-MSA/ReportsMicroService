package com.reportsMicroservice.demo.model.reports;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor

public class TimeOffTransactionReport {
    private String policy;
    private LocalDate requestedOn;
    private LocalDate startDate;
    private LocalDate endDate;
    private String type;
    private String reason;
    private String approvedBy;
    private String changedBy;
    private double duration;
}
