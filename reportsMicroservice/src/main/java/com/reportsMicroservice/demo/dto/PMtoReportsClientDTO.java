package com.reportsMicroservice.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@AllArgsConstructor
@Getter
@Setter
public class PMtoReportsClientDTO implements Serializable {

    private Integer clientId;
    private String clientName;
    private double budgetCost;
    private String projectName;
    private Integer projectId;
}
