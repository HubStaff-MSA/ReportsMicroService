package com.reportsMicroservice.demo.model.others;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
public class Client {
    private Integer clientId;
    //-------
    private String name;
    private String email;
    private String phoneNumber;
    private String address;
    //-------
    private List<Project> projects;
    private boolean billable;
    private BudgetType budgetType;
    private BudgetBasedOn budgetBasedOn;
    //------
    private Double budgetCost;
    private Double budgetNotifyAt;
    private Date budgetStartDate;
    private boolean budgetIncludeNonBillabeTime;
    private Integer organizationId;

    public enum BudgetBasedOn {
        BillRate,
        PayRate
    }

    public enum BudgetType {
        TotalCost,
        TotalHours
    }

}
