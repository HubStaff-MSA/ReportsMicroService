package com.reportsMicroservice.demo.model.reports;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ClientBudgetsReport {
    @Id
    @GeneratedValue
    private UUID id;
    private String clientName;
    private Double totalSpent;
    private Double budget;
    private Double remaining;

}
