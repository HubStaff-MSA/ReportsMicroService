package com.reportsMicroservice.demo.model.reports;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
public class PaymentsReport {
    private String memberName;
    private String paymentType;
    private LocalDate paidOn;
    private Double amount;
}
