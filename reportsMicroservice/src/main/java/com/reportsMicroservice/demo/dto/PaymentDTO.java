package com.reportsMicroservice.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@AllArgsConstructor
@Setter
@Getter
public class PaymentDTO implements Serializable {

    private Integer paymentID;
    private double amount;
    private Integer memberId;
    private Integer payerId;
    private Integer projectId;

}
