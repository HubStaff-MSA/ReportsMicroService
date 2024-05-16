package com.reportsMicroservice.demo.model.reports;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalTime;

@Getter
@Setter
@AllArgsConstructor

public class TimeOffBalancesReport {
    private String policy;
    private Integer Used;
    private Integer Pending;
    private Integer balance;
    private String reason;


}
