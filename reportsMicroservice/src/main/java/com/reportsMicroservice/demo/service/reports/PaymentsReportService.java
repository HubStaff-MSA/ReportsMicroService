package com.reportsMicroservice.demo.service.reports;

import com.reportsMicroservice.demo.model.others.Payment;
import com.reportsMicroservice.demo.model.others.User;
import com.reportsMicroservice.demo.model.reports.PaymentsReport;
import com.reportsMicroservice.demo.repository.others.PaymentRepository;
import com.reportsMicroservice.demo.repository.others.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.stream.Collectors;
import java.util.List;

@Service
public class PaymentsReportService {

    @Autowired
    private UserRepository UserRepository;
    @Autowired
    private PaymentRepository PaymentsRepository;


    public List<PaymentsReport> generatePaymentsReport(LocalDate from, LocalDate to) {
        List<Payment> payments = PaymentRepository.findByDateRange(from, to);
        return payments.stream().collect(Collectors.groupingBy(Payment::getMemberId))
                .entrySet().stream().map(entry -> {
                    User user = UserRepository.findById(entry.getKey());
                    double totalAmount = entry.getValue().stream()
                            .mapToDouble(Payment::getAmount)
                            .sum();
                    return new PaymentsReport(user.getFullName(), "Direct", user.getJoinDate(), totalAmount);
                }).collect(Collectors.toList());
    }

}
