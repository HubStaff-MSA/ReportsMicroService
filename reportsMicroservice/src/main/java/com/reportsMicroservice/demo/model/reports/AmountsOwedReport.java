package com.reportsMicroservice.demo.model.reports;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AmountsOwedReport {
    private String memberName;
    private String email;
    private LocalDate joinDate;
    private Double currentRate;
    private Double regularHours;
    private Double overtime;
    private Double totalHours;
    private Double amountOwed;
}
