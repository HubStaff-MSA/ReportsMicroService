package com.reportsMicroservice.demo.service.reports;

import com.reportsMicroservice.demo.model.others.*;
import com.reportsMicroservice.demo.model.reports.ClientBudgetsReport;
import com.reportsMicroservice.demo.repository.others.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Time;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;


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

    public List<ClientBudgetsReport> generateClientBudgetsReport() {
        List<ClientBudgetsReport> reportList = new ArrayList<>();

        List<Client> clients = clientRepository.findAll();
        List<Payment> payments = paymentRepository.findAll();

        for (Client client : clients) {
            double totalSpent = calculateTotalSpent(client.getClientId(), payments);
            double remainingBudget = getClientBudget(client.getClientId()) - totalSpent;

            ClientBudgetsReport report = new ClientBudgetsReport(
                    client.getName(),
                    totalSpent,
                    getClientBudget(client.getClientId()),
                    remainingBudget);

            reportList.add(report);
        }

        return reportList;
    }

    // Helper method to calculate total spent for a client
    private double calculateTotalSpent(Integer clientId, List<Payment> payments) {
        double totalSpent = 0.0;

        for (Payment payment : payments) {
            if (payment.getPayerId().equals(clientId)) {
                totalSpent += payment.getAmount();
            }
        }

        return totalSpent;
    }

    private double getClientBudget(Integer clientId) {
        List<Project> projects = projectRepository.findAll();
        double totalBudget = 0.0;

        for (Project project : projects) {
            if (project.getClientId().equals(clientId)) {
                totalBudget += project.getBudgetCost();
            }
        }

        return totalBudget;
    }
}
