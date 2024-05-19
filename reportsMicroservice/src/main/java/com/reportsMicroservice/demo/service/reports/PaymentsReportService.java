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
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PaymentsReportService {

    @Autowired
    private UserRepository UserRepository;
    @Autowired
    private PaymentRepository PaymentsRepository;


    public List<PaymentsReport> generatePaymentsReport(Integer userId) {
        // Fetch payments for the specified userId
        List<Payment> payments = PaymentsRepository.findByUserId(userId); // Assuming this method exists in your repository

        Optional<User> userOptional = UserRepository.findById(userId);
        if (!userOptional.isPresent()) {
            return List.of(); // Return an empty list if the user is not found
        }

        User user = userOptional.get();
        double totalAmount = payments.stream()
                .mapToDouble(Payment::getAmount)
                .sum();

        PaymentsReport report = new PaymentsReport(user.getFullName(), "Direct", user.getJoinDate(), totalAmount);
        return List.of(report); // Return a list containing a single report
    }

}
