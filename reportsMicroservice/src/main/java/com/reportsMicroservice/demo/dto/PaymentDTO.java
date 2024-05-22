package com.reportsMicroservice.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Setter
@Getter
public class PaymentDTO {
    private Integer paymentID;
    private double amount;
    private Integer memberId;
    private Integer payerId;

}
