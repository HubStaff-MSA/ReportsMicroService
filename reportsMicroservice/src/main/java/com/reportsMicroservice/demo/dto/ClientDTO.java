package com.reportsMicroservice.demo.dto;

import com.reportsMicroservice.demo.model.others.Project;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@Getter
@Setter
public class ClientDTO {
    private Integer clientId;
    private String clientName;
    private Double budgetCost;
    private List<Project> projects;
}
