package com.reportsMicroservice.demo.repository.others;

import com.reportsMicroservice.demo.model.others.Payment;
import com.reportsMicroservice.demo.model.others.Time_off;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Repository
public class PaymentRepository {
    static List<Payment> payments = new ArrayList<Payment>();

    public PaymentRepository() {
        payments.add(new Payment(1, 100.0, "Payment 1", 1, LocalDate.of(2021, 01, 01), LocalDate.of(2021, 01, 01), Payment.PaymentStatus.APPROVED, LocalDateTime.of(2021, 01, 01, 01, 01), LocalDateTime.of(2021, 01, 01, 01, 01), 1));
        payments.add(new Payment(2, 200.0, "Payment 2", 2, LocalDate.of(2021, 01, 02), LocalDate.of(2021, 01, 02), Payment.PaymentStatus.APPROVED, LocalDateTime.of(2021, 01, 02, 02, 02), LocalDateTime.of(2021, 01, 02, 02, 02), 2));
        payments.add(new Payment(3, 300.0, "Payment 3", 3, LocalDate.of(2021, 01, 03), LocalDate.of(2021, 01, 03), Payment.PaymentStatus.APPROVED, LocalDateTime.of(2021, 01, 03, 03, 03), LocalDateTime.of(2021, 01, 03, 03, 03), 3));
    }

    public static List<Payment> findByDateRange(LocalDate from, LocalDate to) {
        return payments.stream()
                .filter(payment -> payment.getFrom_date().isAfter(from) && payment.getFrom_date().isBefore(to))
                .collect(java.util.stream.Collectors.toList());
    }

    public static List<Payment> findAll() {
        return payments;
    }

    public Payment findByUserId(Integer userId) {
        return payments.stream()
                .filter(time_off -> time_off.getMemberId().equals(userId))
                .findFirst()
                .orElse(null);
    }
}
