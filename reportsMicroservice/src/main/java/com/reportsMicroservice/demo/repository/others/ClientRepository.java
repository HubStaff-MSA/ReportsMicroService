package com.reportsMicroservice.demo.repository.others;

import com.reportsMicroservice.demo.model.others.Client;
import com.reportsMicroservice.demo.model.others.Payment;
import com.reportsMicroservice.demo.model.others.Project;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Repository
public class ClientRepository {

    private final ProjectRepository projectRepository;
    private final List<Client> clients = new ArrayList<>();

    @Autowired
    public ClientRepository(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
        initializeClients();
    }

    private void initializeClients() {
        List<Project> projectsClientA = new ArrayList<>();
        projectsClientA.add(new Project(4, "Project L", true, true, false, 1, 10000.0, Project.BudgetType.TotalCost, Project.BudgetBasedOn.BillRate, 1.0, LocalDate.of(2021, 1, 1), false));
        projectsClientA.add(new Project(5, "Project M", true, true, false, 2, 20000.0, Project.BudgetType.TotalCost, Project.BudgetBasedOn.BillRate, 1.0, LocalDate.of(2021, 2, 2), false));

        List<Project> projectsClientB = new ArrayList<>();
        projectsClientB.add(new Project(6, "Project Z", true, true, false, 3, 30000.0, Project.BudgetType.TotalCost, Project.BudgetBasedOn.BillRate, 1.0, LocalDate.of(2021, 3, 3), false));

        clients.add(new Client(1, "Client A", "clientA@mail.com", "1234567890", "111 Main St", projectsClientA));
        clients.add(new Client(2, "Client B", "clientB@mail.com", "1234567890", "222 Main St", projectsClientB));
        clients.add(new Client(3, "Client C", "clientC@mail.com", "1234567890", "333 Main St", null));
//
//        for (Project project : projectsClientA) {
//            List<Payment> payments = new ArrayList<>();
//            payments.add(new Payment(1, 100.0, "Payment 1", project.getProjectId(), LocalDate.of(2021, 1, 1), LocalDate.of(2021, 1, 1), Payment.PaymentStatus.APPROVED, LocalDateTime.of(2021, 1, 1, 1, 1), LocalDateTime.of(2021, 1, 1, 1, 1), 1));
//            project.setPayments(payments);
//        }
    }

    public List<Client> findAll() {
        return clients;
    }

    public Client findById(Integer clientId) {
        return clients.stream()
                .filter(client -> client.getClientId().equals(clientId))
                .findFirst()
                .orElse(null);
    }
}
