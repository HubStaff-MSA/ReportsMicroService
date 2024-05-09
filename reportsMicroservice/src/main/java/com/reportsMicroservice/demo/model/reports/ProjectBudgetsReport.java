package com.reportsMicroservice.demo.model.reports;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class ProjectBudgetsReport {
    private String projectName;
    private Double totalSpent;
    private Double budget;
    private Double remaining;
}
