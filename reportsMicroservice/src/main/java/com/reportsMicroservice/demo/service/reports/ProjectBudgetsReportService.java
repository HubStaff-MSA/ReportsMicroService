package com.reportsMicroservice.demo.service.reports;

import com.reportsMicroservice.demo.model.others.Payment;
import com.reportsMicroservice.demo.model.others.Project;
import com.reportsMicroservice.demo.model.reports.ProjectBudgetsReport;
import com.reportsMicroservice.demo.repository.others.PaymentRepository;
import com.reportsMicroservice.demo.repository.others.ProjectRepository;
import com.reportsMicroservice.demo.repository.others.Timesheet_timeRepository;
import com.reportsMicroservice.demo.repository.others.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProjectBudgetsReportService {
    @Autowired
    private ProjectRepository projectRepository;

    @Autowired
    private Timesheet_timeRepository Timesheet_timeRepository;

    @Autowired
    private UserRepository UserRepository;

    @Autowired
    private PaymentRepository PaymentRepository;

    public List<ProjectBudgetsReport> generateProjectBudgetsReport() {
        List<ProjectBudgetsReport> reportList = new ArrayList<>();
        List<Project> projects = projectRepository.findAll();
        List<Payment> payments = PaymentRepository.findAll();

        for (Project project : projects) {
            double totalSpent = calculateTotalSpent(project.getProjectId(), payments);
            double remainingBudget = project.getBudgetCost() - totalSpent;

            ProjectBudgetsReport report = new ProjectBudgetsReport(
                    project.getProjectName(),
                    totalSpent,
                    project.getBudgetCost(),
                    remainingBudget);

            reportList.add(report);
        }

        return reportList;

    }

    // Helper method to calculate total spent for a project
    private double calculateTotalSpent(Integer projectId, List<Payment> payments) {
        double totalSpent = 0.0;

        for (Payment payment : payments) {
            if (payment.getPayerId().equals(projectId)) {
                totalSpent += payment.getAmount();
            }
        }

        return totalSpent;
    }

}
