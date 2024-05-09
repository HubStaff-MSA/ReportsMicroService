package com.reportsMicroservice.demo.model.reports;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
public class AmountsOwedReport {
    private String memberName;
    private String email;
    private LocalDate joinDate;
    private Double currentRate;
    private Double regularHours;
    private Double overtime;
    private Double totalHours;
    private Double amountOwed;
}
