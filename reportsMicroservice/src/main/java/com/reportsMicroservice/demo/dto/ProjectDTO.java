package com.reportsMicroservice.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@AllArgsConstructor
@Getter
@Setter
public class ProjectDTO implements Serializable {

    private Integer projectId;
    private String projectName;
    private Integer clientId;
    private double BudgetCost;

}