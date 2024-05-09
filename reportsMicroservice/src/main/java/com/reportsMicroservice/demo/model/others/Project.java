package com.reportsMicroservice.demo.model.others;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Getter
@AllArgsConstructor
@Setter
public class Project {

    private Integer projectId;
    private String projectName;
    private boolean billable;
    private boolean disableActivity;
    private boolean disableIdleTime;
    private Integer clientId;
    private Double budgetCost;

    private BudgetType budgetType; ////
    private BudgetBasedOn budgetBasedOn; ////
    private Double budgetNotifyAt;
    private LocalDate budgetStartDate;
    private boolean budgetIncludeNonBillabeTime;

    public enum BudgetType {
        TotalCost,
        TotalHours
    }

    public enum BudgetBasedOn {
        BillRate,
        PayRate
    }

    public Project(Integer projectId, String projectName, boolean billable, boolean disableActivity, boolean disableIdleTime, Integer clientId, Double budgetCost) {
        this.projectId = projectId;
        this.projectName = projectName;
        this.billable = billable;
        this.disableActivity = disableActivity;
        this.disableIdleTime = disableIdleTime;
        this.clientId = clientId;
        this.budgetCost = budgetCost;
    }
}

