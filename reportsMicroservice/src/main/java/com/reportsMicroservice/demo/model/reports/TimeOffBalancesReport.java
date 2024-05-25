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
public class TimeOffBalancesReport {
    private String policy;
    private Integer Used;
    private Integer Pending;
    private Integer balance;
    private String reason;


}
