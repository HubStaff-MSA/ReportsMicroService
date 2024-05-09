package com.reportsMicroservice.demo.model.reports;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class ClientBudgetsReport {
    private String clientName;
    private Double totalSpent;
    private Double budget;
    private Double remaining;

}
