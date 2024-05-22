package com.reportsMicroservice.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

@AllArgsConstructor
@Getter
@Setter
public class ProjectDTO implements Serializable {

    private Integer id;
    private String projectName;
    private Integer organizationId;
//    private List<Integer> employees;
    //////////////////////////////////
    private Double BudgetCost;

}