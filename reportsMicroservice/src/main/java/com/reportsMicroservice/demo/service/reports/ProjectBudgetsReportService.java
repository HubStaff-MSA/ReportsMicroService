package com.reportsMicroservice.demo.service.reports;

import com.reportsMicroservice.demo.model.others.Project;
import com.reportsMicroservice.demo.model.others.Timesheet_time;
import com.reportsMicroservice.demo.model.others.User;
import com.reportsMicroservice.demo.model.reports.ProjectBudgetsReport;
import com.reportsMicroservice.demo.repository.others.ProjectRepository;
import com.reportsMicroservice.demo.repository.others.Timesheet_timeRepository;
import com.reportsMicroservice.demo.repository.others.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
public class ProjectBudgetsReportService {
    @Autowired
    private ProjectRepository projectRepository;

    @Autowired
    private Timesheet_timeRepository Timesheet_timeRepository;

    @Autowired
    private UserRepository UserRepository;

    public List<ProjectBudgetsReport> generateProjectBudgetsReport() {
        List<Project> projects = projectRepository.findAll();
        return projects.stream().map(project -> {
            double totalSpent = calculateTotalSpentForProject(project.getProjectId());
            double remaining = project.getBudgetCost() - totalSpent;
            return new ProjectBudgetsReport(project.getProjectName(), totalSpent, project.getBudgetCost(), remaining);
        }).collect(Collectors.toList());
    }

    private double calculateTotalSpentForProject(Integer projectId) {
        List<Timesheet_time> timesheets = Timesheet_timeRepository.findByProjectId(projectId);
        List<Integer> userIds = timesheets.stream()
                .map(Timesheet_time::getUserId)
                .collect(Collectors.toList());  // Collect as List, since List is Iterable

        List<User> users = UserRepository.findAllById(userIds);
        Map<Integer, User> userMap = users.stream()
                .collect(Collectors.toMap(User::getId, Function.identity()));


        double totalSpent = timesheets.stream()
                .mapToDouble(timesheet -> {
                    User user = userMap.get(timesheet.getUserId());
                    return user != null ? timesheet.calculateDurationInHours() * user.getHourlyRate().doubleValue() : 0.0;
                })
                .sum();

        return totalSpent;
    }

}
