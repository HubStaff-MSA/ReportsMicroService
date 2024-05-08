package com.reportsMicroservice.demo.model.others;

import jakarta.persistence.*;
import lombok.Getter;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Getter
@Entity
@Table(name = "Project")
public class Project {
    @Id
    @Column(name = "projectId")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer projectId;

    @Getter
    private String projectName;
    @Getter
    private boolean billable;
    @Getter
    private boolean disableActivity;
    @Getter
    private boolean disableIdleTime;
    @Getter
    private Integer clientId;
    //private BudgetType budgetType;
    //private BudgetBasedOn budgetBasedOn;
    @Getter
    private Double budgetCost;
    @Getter
    private Double budgetNotifyAt;
    @Getter
    private Date budgetStartDate;
    @Getter
    private boolean budgetIncludeNonBillabeTime;

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
