package com.reportsMicroservice.demo.model.reports;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.UUID;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AmountsOwedReport {

    @Id
    @GeneratedValue
    private UUID id;

    private String memberName;
    private String email;
    private LocalDate joinDate;
    private Double currentRate;
    private Double regularHours;
    private Double overtime;
    private Double totalHours;
    private Double amountOwed;
}
