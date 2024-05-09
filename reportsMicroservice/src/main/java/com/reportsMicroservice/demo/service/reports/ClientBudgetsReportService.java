package com.reportsMicroservice.demo.service.reports;

import com.reportsMicroservice.demo.model.others.Client;
import com.reportsMicroservice.demo.model.others.Project;
import com.reportsMicroservice.demo.model.others.Timesheet_time;
import com.reportsMicroservice.demo.model.others.User;
import com.reportsMicroservice.demo.model.reports.ClientBudgetsReport;
import com.reportsMicroservice.demo.repository.others.ClientRepository;
import com.reportsMicroservice.demo.repository.others.Timesheet_timeRepository;
import com.reportsMicroservice.demo.repository.others.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Time;
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
    private ClientRepository ClientRepository;

    public List<ClientBudgetsReport> generateClientBudgetsReport() {
        List<Client> clients = ClientRepository.findAll();
        System.out.println("Clients: " + clients);

        return clients.stream().map(client -> {
            double totalSpent = client.getProjects().stream()
                    .mapToDouble(project -> calculateTotalSpentForProject(project.getProjectId()))
                    .sum();
            System.out.println("Total Spent: " + totalSpent);

            double totalBudget = client.getProjects().stream()
                    .mapToDouble(Project::getBudgetCost)
                    .sum();
            System.out.println("Total Budget: " + totalBudget);

            double remaining = totalBudget - totalSpent;
            System.out.println("Remaining: " + remaining);

            return new ClientBudgetsReport(client.getName(), totalSpent, totalBudget, remaining);
        }).collect(Collectors.toList());
    }


    private double calculateTotalSpentForProject(Integer projectId) {
        // Retrieve timesheets associated with the project
        List<Timesheet_time> timesheets = Timesheet_timeRepository.findByProjectId(projectId);

        // Extract user IDs from timesheets
        List<Integer> userIds = timesheets.stream()
                .map(Timesheet_time::getUserId)
                .collect(Collectors.toList());

        // Retrieve users based on the extracted user IDs
        List<User> users = UserRepository.findAllById(userIds);

        // Map users to user IDs for efficient lookup
        Map<Integer, User> userMap = users.stream()
                .collect(Collectors.toMap(User::getId, Function.identity()));

        // Calculate total spent based on timesheet data and user hourly rates
        double totalSpent = timesheets.stream()
                .mapToDouble(timesheet -> {
                    User user = userMap.get(timesheet.getUserId());
                    if (user != null) {
                        // Calculate cost based on hours worked and hourly rate
                        return timesheet.calculateDurationInHours() * user.getHourlyRate().doubleValue();
                    } else {
                        return 0.0; // Default to 0 if user is not found (should not happen ideally)
                    }
                })
                .sum();

        return totalSpent;
    }




}
