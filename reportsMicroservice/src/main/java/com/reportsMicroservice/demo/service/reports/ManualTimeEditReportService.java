package com.reportsMicroservice.demo.service.reports;


import com.reportsMicroservice.demo.model.others.Project;
import com.reportsMicroservice.demo.model.others.ToDo;
import com.reportsMicroservice.demo.model.others.User;
import com.reportsMicroservice.demo.model.reports.ManualTimeEditReport;
import com.reportsMicroservice.demo.model.reports.TimeOffTransactionReport;
import com.reportsMicroservice.demo.repository.others.ProjectRepository;
import com.reportsMicroservice.demo.repository.others.ToDoRepository;
import com.reportsMicroservice.demo.repository.others.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class ManualTimeEditReportService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ToDoRepository toDoRepository;

    @Autowired
    private ProjectRepository projectRepository;

    public List<ManualTimeEditReport> generateManualTimeEditReports() {
        List<ManualTimeEditReport> reportList = new ArrayList<>();

        List<User> users = userRepository.findAll();

        for (User user : users) {
            Project project = projectRepository.findById(user.getProjectId());
            if (project == null) {
                continue; // Skip users without associated projects
            }

            ToDo toDo = toDoRepository.findByUserId(user.getId());

            LocalTime currentTime = LocalTime.now();

            //member, about , project, todoo , action, timespan, timechange, reason, changedBy, changedAt
            ManualTimeEditReport report = new ManualTimeEditReport(
                    user.getFullName(),
                    user.getRole() + user.getEmail(),
                    project.getProjectName(),
                    toDo.getContent(),
                    user.getFullName(),
                    currentTime

            );
            reportList.add(report);
        }
        return reportList;
    }
}