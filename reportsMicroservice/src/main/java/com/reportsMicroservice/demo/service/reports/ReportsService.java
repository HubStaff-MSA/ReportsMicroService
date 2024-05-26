package com.reportsMicroservice.demo.service.reports;

import com.reportsMicroservice.demo.dto.*;
import com.reportsMicroservice.demo.model.reports.*;
import com.reportsMicroservice.demo.repository.reports.*;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class ReportsService {

    @Autowired
    private WorkSessionReportRepository workSessionReportRepository;

    @Autowired
    private TimeAndActivityReportRepository timeAndActivityReportRepository;

    @Autowired
    private WeeklyLimitReportRepository weeklyLimitReportRepository;

    @Autowired
    private ProjectBudgetsReportRepository projectBudgetsReportRepository;

    @Autowired
    private ClientBudgetsReportRepository clientBudgetsReportRepository;

    @Autowired
    private PaymentsReportRepository paymentsReportRepository;

    @Autowired
    private AmountsOwedReportRepository amountsOwedReportRepository;


    @Transactional
    public List<WorkSessionReport> generateWorkSessionReports(UserDTO user, List<PMtoReportsProjectDTO> projects,
                                                              PMtoReportsClientDTO client, List<PMtoReportsToDoDTO> toDos,
                                                              List<TT_dto> trackTimes) {
        List<WorkSessionReport> reportList = new ArrayList<>();
        for (PMtoReportsProjectDTO project : projects) {
            for (TT_dto timesheet : trackTimes) {
                if (!project.getProjectName().equals(timesheet.getProject())) {
                    continue;
                }
                for (PMtoReportsToDoDTO toDo : toDos) {
                    if (timesheet.getTo_do().equals(toDo.getTitle())) {
                        WorkSessionReport report = new WorkSessionReport(UUID.randomUUID(),
                                client.getClientName(),
                                project.getProjectName(),
                                user.getFullName(),
                                toDo.getDescription(),
                                timesheet.getStartTime(),
                                timesheet.getEndTime(),
                                timesheet.getDuration());
                        reportList.add(report);
                        workSessionReportRepository.save(report);
                    }
                }
            }
        }
        return reportList;
    }

    @Transactional
    public List<TimeAndActivityReport> generateTimeAndActivityReports(UserDTO user, List<PMtoReportsProjectDTO> projects,
                                                                      List<TT_dto> timesheets, List<PaymentDTO> payments) {
        List<TimeAndActivityReport> reportList = new ArrayList<>();
        for (PMtoReportsProjectDTO project : projects) {
            for (TT_dto timesheet : timesheets) {
                if (project.getProjectName().equals(timesheet.getProject())) {
                    double totalHours = timesheets.stream().mapToDouble(TT_dto::getDuration).sum();
                    double regularHours = Math.min(totalHours, user.getWeeklyLimit());
                    double overtime = Math.max(0, totalHours - user.getWeeklyLimit());
                    double totalSpent = payments.stream().mapToDouble(PaymentDTO::getAmount).sum();

                    TimeAndActivityReport report = new TimeAndActivityReport(UUID.randomUUID(),
                            project.getProjectName(),
                            user.getFullName(),
                            regularHours,
                            overtime,
                            totalHours,
                            totalSpent,
                            regularHours * user.getHourlyRate());

                    reportList.add(report);
                    timeAndActivityReportRepository.save(report);
                }
            }
        }
        return reportList;
    }

    @Transactional
    public List<WeeklyLimitReport> generateWeeklyLimitReport(UserDTO user) {
        List<WeeklyLimitReport> reportList = new ArrayList<>();
        if (user.getWeeklyLimit() > 0) {
            double totalHoursWorked = user.getTotalHoursWorked();
            double weeklyLimit = user.getWeeklyLimit();
            WeeklyLimitReport report = new WeeklyLimitReport(UUID.randomUUID(),
                    user.getId(),
                    user.getFullName(),
                    totalHoursWorked,
                    weeklyLimit,
                    calculatePercentageUsed(totalHoursWorked, weeklyLimit),
                    calculateRemainingHours(totalHoursWorked, weeklyLimit));
            reportList.add(report);
            weeklyLimitReportRepository.save(report);
        }
        return reportList;
    }

    private double calculatePercentageUsed(double totalHoursWorked, double weeklyLimit) {
        return weeklyLimit > 0 ? (totalHoursWorked / weeklyLimit) * 100.0 : 0.0;
    }

    private double calculateRemainingHours(double totalHoursWorked, double weeklyLimit) {
        return Math.max(weeklyLimit - totalHoursWorked, 0.0);
    }

    @Transactional
    public List<ProjectBudgetsReport> generateProjectBudgetsReport(PMtoReportsProjectDTO project, List<PaymentDTO> payments) {
        List<ProjectBudgetsReport> reportList = new ArrayList<>();
        double totalSpent = calculateTotalSpent(project.getProjectId(), payments);
        double remainingBudget = project.getBudgetCost() - totalSpent;

        ProjectBudgetsReport report = new ProjectBudgetsReport(UUID.randomUUID(),
                project.getProjectName(),
                totalSpent,
                project.getBudgetCost(),
                remainingBudget);

        reportList.add(report);
        projectBudgetsReportRepository.save(report);
        return reportList;
    }

    private double calculateTotalSpent(Integer projectId, List<PaymentDTO> payments) {
        return payments.stream()
                .filter(payment -> payment.getProjectId().equals(projectId))
                .mapToDouble(PaymentDTO::getAmount)
                .sum();
    }

    @Transactional
    public List<ClientBudgetsReport> generateClientBudgetsReport(PMtoReportsClientDTO client, List<PaymentDTO> payments) {
        List<ClientBudgetsReport> reportList = new ArrayList<>();
        double totalSpent = calculateTotalSpentClient(client.getClientId(), payments);
        double clientBudget = client.getBudgetCost();
        double remainingBudget = clientBudget - totalSpent;

        ClientBudgetsReport report = new ClientBudgetsReport(
                UUID.randomUUID(),
                client.getClientName(),
                totalSpent,
                clientBudget,
                remainingBudget);

        reportList.add(report);
        clientBudgetsReportRepository.save(report);
        return reportList;
    }

    private double calculateTotalSpentClient(Integer clientId, List<PaymentDTO> payments) {
        return payments.stream()
                .filter(payment -> payment.getPayerId().equals(clientId))
                .mapToDouble(PaymentDTO::getAmount)
                .sum();
    }

    @Transactional
    public List<PaymentsReport> generatePaymentsReport(UserDTO user, List<PaymentDTO> payments) {
        List<PaymentsReport> reportList = new ArrayList<>();
        double totalAmount = payments.stream().mapToDouble(PaymentDTO::getAmount).sum();

        PaymentsReport report = new PaymentsReport(UUID.randomUUID(), user.getFullName(), user.getHireDate(), totalAmount);
        reportList.add(report);
        paymentsReportRepository.save(report);
        return reportList;
    }

    @Transactional
    public List<AmountsOwedReport> generateAmountsOwedReport(UserDTO user, List<TT_dto> timesheets) {
        List<AmountsOwedReport> reportList = new ArrayList<>();
        double weeklyLimit = Math.max(user.getWeeklyLimit(), 40.0);
        double totalHours = timesheets.stream().mapToDouble(TT_dto::getDuration).sum();
        double regularHours = Math.min(totalHours, weeklyLimit);
        double overtimeHours = Math.max(0, totalHours - weeklyLimit);
        double amountOwed = regularHours * user.getHourlyRate() + overtimeHours * (user.getHourlyRate() * 1.5);

        AmountsOwedReport report = new AmountsOwedReport(UUID.randomUUID(),
                user.getFullName(), user.getWorkEmail(), user.getHireDate(),
                user.getHourlyRate(), regularHours, overtimeHours,
                totalHours, amountOwed);

        reportList.add(report);
        amountsOwedReportRepository.save(report);
        return reportList;
    }
}
