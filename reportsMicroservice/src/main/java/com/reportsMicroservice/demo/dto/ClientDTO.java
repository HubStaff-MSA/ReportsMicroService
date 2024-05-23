package com.reportsMicroservice.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

@AllArgsConstructor
@Getter
@Setter
public class ClientDTO implements Serializable {

    private Integer clientId;
    private String clientName;
    private double budgetCost;
    private String projectName;
    private Integer projectId;
}
