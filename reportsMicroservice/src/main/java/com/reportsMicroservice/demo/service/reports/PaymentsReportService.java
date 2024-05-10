package com.reportsMicroservice.demo.service.reports;

import com.reportsMicroservice.demo.model.others.Payment;
import com.reportsMicroservice.demo.model.others.User;
import com.reportsMicroservice.demo.model.reports.PaymentsReport;
import com.reportsMicroservice.demo.repository.others.PaymentRepository;
import com.reportsMicroservice.demo.repository.others.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class PaymentsReportService {

    @Autowired
    private UserRepository UserRepository;
    @Autowired
    private PaymentRepository PaymentsRepository;


    public List<PaymentsReport> generatePaymentsReport() {
        List<Payment> payments = PaymentRepository.findAll(); // Fetch all payments

        Map<Integer, List<Payment>> groupedPayments = payments.stream()
                .collect(Collectors.groupingBy(Payment::getMemberId));

        return groupedPayments.entrySet().stream().map(entry -> {
            User user = UserRepository.findById(entry.getKey());
            if (user != null) {
                double totalAmount = entry.getValue().stream()
                        .mapToDouble(Payment::getAmount)
                        .sum();
                return new PaymentsReport(user.getFullName(), "Direct", user.getJoinDate(), totalAmount);
            } else {
                return null; // User with the specified member ID was not found
            }
        }).filter(Objects::nonNull).collect(Collectors.toList());
    }

}
