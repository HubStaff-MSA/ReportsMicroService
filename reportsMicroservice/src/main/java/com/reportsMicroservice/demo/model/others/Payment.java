package com.reportsMicroservice.demo.model.others;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
public class Payment {
    private Integer id;
    private double amount;
    private String description;
    private Integer memberId;
    private LocalDate from_date;
    private LocalDate to_date;
    private PaymentStatus status;
    private LocalDateTime creation_date;
    private LocalDateTime last_edited_date;
    private Integer payerId;

    public enum PaymentStatus {
        PENDING, APPROVED, REJECTED
    }

}
