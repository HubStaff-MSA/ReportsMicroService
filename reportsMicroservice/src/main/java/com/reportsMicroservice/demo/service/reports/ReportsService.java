package com.reportsMicroservice.demo.service.reports;

import com.reportsMicroservice.demo.dto.*;
import com.reportsMicroservice.demo.model.reports.*;
import com.reportsMicroservice.demo.repository.reports.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

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


    /////////////////////////////////// GENERATE WORK SESSION REPORTS ///////////////////////////////////
    public List<WorkSessionReport> generateWorkSessionReports(UserDTO user, List<ProjectDTO> project, ClientDTO client,
                                                              List<ToDoDTO> toDoDTOS, List<TrackTimeDTO> trackTimeDTOS) {
        List<WorkSessionReport> reportList = new ArrayList<>();

        // Process each combination of timesheet and todo
        for (ProjectDTO projectDTO : project) {
            for (TrackTimeDTO timesheet : trackTimeDTOS) {
                if (!projectDTO.getProjectName().equals(timesheet.getProject())) {
                    continue;
                }
                for (ToDoDTO toDo : toDoDTOS) {
                    if (!timesheet.getTo_do().equals(toDo.getTitle())) {
                        continue;
                    } else {
                        WorkSessionReport report = new WorkSessionReport(
                                client.getClientName(),
                                projectDTO.getProjectName(),
                                user.getFullName(),
                                toDo.getDescription(),
                                timesheet.getStartTime(),
                                timesheet.getEndTime(),
                                timesheet.getDuration());

                        reportList.add(report);
                        workSessionReportRepository.save(report); // Save the report
                    }
                }
            }
        }

        return reportList;
    }

    /////////////////////////////////// GENERATE TIME AND ACTIVITY REPORTS ///////////////////////////////////

    public List<TimeAndActivityReport> generateTimeAndActivityReports(UserDTO user, List<ProjectDTO> projects,
                                                                      List<TrackTimeDTO> timesheets, List<PaymentDTO> payments) {

        List<TimeAndActivityReport> reportList = new ArrayList<>();

        for (ProjectDTO projectDTO : projects) {
            for (TrackTimeDTO timesheet : timesheets) {
                if (!projectDTO.getProjectName().equals(timesheet.getProject())) {
                    continue;
                }
                double TotalHours = timesheets.stream().mapToDouble(TrackTimeDTO::getDuration).sum();
                double regularHours = Math.min(TotalHours, user.getWeeklyLimit());
                double overtime = Math.max(0, TotalHours - user.getWeeklyLimit());
                double totalSpent = payments.stream().mapToDouble(PaymentDTO::getAmount).sum();

                TimeAndActivityReport report = new TimeAndActivityReport(
                        projectDTO.getProjectName(),
                        user.getFullName(),
                        regularHours,
                        overtime,
                        TotalHours,
                        timesheet.getManual(),
                        totalSpent,
                        regularHours * user.getHourlyRate()
                );

                reportList.add(report);
                timeAndActivityReportRepository.save(report); // Save the report

            }
        }
        return reportList;
    }


    //////////////////////////////////// GENERATE WEEKLY LIMIT REPORTS ////////////////////////////////////

    public List<WeeklyLimitReport> generateWeeklyLimitReport(UserDTO user) {
        List<WeeklyLimitReport> reportList = new ArrayList<>();

        if (user.getWeeklyLimit() > 0) {
            double totalHoursWorked = user.getTotalHoursWorked();
            double weeklyLimit = user.getWeeklyLimit();

            WeeklyLimitReport report = new WeeklyLimitReport(
                    user.getId(),
                    user.getFullName(),
                    totalHoursWorked,
                    weeklyLimit,
                    calculatePercentageUsed(totalHoursWorked, weeklyLimit),
                    calculateRemainingHours(totalHoursWorked, weeklyLimit));

            reportList.add(report);
            weeklyLimitReportRepository.save(report); // Save the report
        }


        return reportList;
    }

    private double calculatePercentageUsed(double totalHoursWorked, double weeklyLimit) {
        if (weeklyLimit > 0) {
            return (totalHoursWorked / weeklyLimit) * 100.0;
        } else {
            return 0.0;
        }
    }

    // Helper method to calculate remaining hours within weekly limit
    private double calculateRemainingHours(double totalHoursWorked, double weeklyLimit) {
        return Math.max(weeklyLimit - totalHoursWorked, 0.0);
    }

    //////////////////////////////////// Project Budgets Report ////////////////////////////////////

    public List<ProjectBudgetsReport> generateProjectBudgetsReport(ProjectDTO project, List<PaymentDTO> payments) {
        List<ProjectBudgetsReport> reportList = new ArrayList<>();

        double totalSpent = calculateTotalSpent(project.getProjectId(), payments);
        double remainingBudget = project.getBudgetCost() - totalSpent;

        ProjectBudgetsReport report = new ProjectBudgetsReport(
                project.getProjectName(),
                totalSpent,
                project.getBudgetCost(),
                remainingBudget);

        reportList.add(report);
        projectBudgetsReportRepository.save(report); // Save the report


        return reportList;
    }

    // Helper method to calculate total spent for a project
    private double calculateTotalSpent(Integer projectId, List<PaymentDTO> payments) {
        double totalSpent = 0.0;

        for (PaymentDTO payment : payments) {
            if (payment.getProjectId().equals(projectId)) {
                totalSpent += payment.getAmount();
            }
        }

        return totalSpent;
    }

    //////////////////////////////////// GENERATE CLIENT BUDGETS REPORTS ////////////////////////////////////

    public List<ClientBudgetsReport> generateClientBudgetsReport(ClientDTO client, List<PaymentDTO> payments) {
        List<ClientBudgetsReport> reportList = new ArrayList<>();

        double totalSpent = calculateTotalSpentClient(client.getClientId(), payments);
        double clientBudget = client.getBudgetCost();
        double remainingBudget = clientBudget - totalSpent;

        ClientBudgetsReport report = new ClientBudgetsReport(
                client.getClientName(),
                totalSpent,
                clientBudget,
                remainingBudget);

        reportList.add(report);
        clientBudgetsReportRepository.save(report); // Save the report


        return reportList;
    }

    // Helper method to calculate total spent for a client
    private double calculateTotalSpentClient(Integer clientId, List<PaymentDTO> payments) {
        return payments.stream()
                .filter(payment -> payment.getPayerId().equals(clientId))
                .mapToDouble(PaymentDTO::getAmount)
                .sum();
    }

    //////////////////////////////////// GENERATE PAYMENTS REPORTS ////////////////////////////////////

    public List<PaymentsReport> generatePaymentsReport(UserDTO user, List<PaymentDTO> payments) {
        List<PaymentsReport> reportList = new ArrayList<>();

        double totalAmount = payments.stream()
                .mapToDouble(PaymentDTO::getAmount)
                .sum();

        PaymentsReport report = new PaymentsReport(user.getFullName(), user.getHireDate(), totalAmount);

        reportList.add(report);
        paymentsReportRepository.save(report); // Save the report

        return reportList;
    }

    //////////////////////////////////// GENERATE AMOUNTS OWED REPORTS ///////////////////////////////////

    public List<AmountsOwedReport> generateAmountsOwedReport(UserDTO user, List<TrackTimeDTO> timesheets) {
        List<AmountsOwedReport> reportList = new ArrayList<>();

        double weeklyLimit = Math.max(user.getWeeklyLimit(), 40.0);
        double totalHours = timesheets.stream().mapToDouble(TrackTimeDTO::getDuration).sum();
        double regularHours = Math.min(totalHours, weeklyLimit);
        double overtimeHours = Math.max(0, totalHours - weeklyLimit);
        double amountOwed = regularHours * user.getHourlyRate() + overtimeHours * (user.getHourlyRate() * 1.5);

        AmountsOwedReport report = new AmountsOwedReport(
                user.getFullName(), user.getWorkEmail(), user.getHireDate(),
                user.getHourlyRate(), regularHours, overtimeHours,
                totalHours, amountOwed);

        reportList.add(report);
        amountsOwedReportRepository.save(report); // Save the report

        return reportList;

    }


}
