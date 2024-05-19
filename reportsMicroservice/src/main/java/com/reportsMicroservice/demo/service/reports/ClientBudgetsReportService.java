package com.reportsMicroservice.demo.service.reports;

import com.reportsMicroservice.demo.model.others.Client;
import com.reportsMicroservice.demo.model.others.Payment;
import com.reportsMicroservice.demo.model.others.Project;
import com.reportsMicroservice.demo.model.reports.ClientBudgetsReport;
import com.reportsMicroservice.demo.repository.others.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
public class ClientBudgetsReportService {

    @Autowired
    private Timesheet_timeRepository Timesheet_timeRepository;
    @Autowired
    private UserRepository UserRepository;
    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private ProjectRepository projectRepository;

    @Autowired
    private PaymentRepository paymentRepository;

    public List<ClientBudgetsReport> generateClientBudgetsReport(Integer clientID) {
        List<ClientBudgetsReport> reportList = new ArrayList<>();

        Optional<Client> optionalClient = clientRepository.findById(clientID);
        if (optionalClient.isPresent()) {
            Client client = optionalClient.get();
            List<Payment> payments = paymentRepository.findAll(); // Assuming all payments are still needed to compute

            double totalSpent = calculateTotalSpent(client.getClientId(), payments);
            double clientBudget = client.getBudgetCost(); // Directly using the budgetCost attribute
            double remainingBudget = clientBudget - totalSpent;

            ClientBudgetsReport report = new ClientBudgetsReport(
                    client.getName(),
                    totalSpent,
                    clientBudget,
                    remainingBudget);

            reportList.add(report);
        }

        return reportList;
    }

    // Helper method to calculate total spent for a client
    private double calculateTotalSpent(Integer clientId, List<Payment> payments) {
        return payments.stream()
                .filter(payment -> payment.getPayerId().equals(clientId))
                .mapToDouble(Payment::getAmount)
                .sum();
    }

}
