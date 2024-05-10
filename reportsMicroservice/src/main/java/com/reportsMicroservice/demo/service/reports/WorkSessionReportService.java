package com.reportsMicroservice.demo.service.reports;

import com.reportsMicroservice.demo.model.others.*;
import com.reportsMicroservice.demo.model.reports.WorkSessionReport;
import com.reportsMicroservice.demo.repository.others.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


@Service
public class WorkSessionReportService {
        @Autowired
        private ProjectRepository projectRepository;
        @Autowired
        private ClientRepository clientRepository;
        @Autowired
        private UserRepository userRepository;
        @Autowired
        private ToDoRepository toDoRepository;
        @Autowired
        private Timesheet_timeRepository timesheetRepository;


    public List<WorkSessionReport> generateWorkSessionReports() {
        List<WorkSessionReport> reportList = new ArrayList<>();

        List<User> users = userRepository.findAll();

        for (User user : users) {
            Project project = projectRepository.findById(user.getProjectId());
            if (project == null) {
                continue; // Skip users without associated projects
            }

            Client client = clientRepository.findById(project.getClientId());
            if (client == null) {
                continue; // Skip users with projects not associated with a client
            }

            String memberName = user.getFullName();

            ToDo toDo = toDoRepository.findByUserId(user.getId());
            Timesheet_time timesheet = timesheetRepository.findByUserId(user.getId());

            if (toDo == null || timesheet == null) {
                continue; // Skip users without associated to-do or timesheet data
            }

            WorkSessionReport report = new WorkSessionReport(
                    client.getName(),
                    project.getProjectName(),
                    memberName,
                    toDo.getContent(),
                    timesheet.isManual(),
                    timesheet.getStartTime(),
                    timesheet.getEndTime(),
                    timesheet.calculateDurationInHours());

            reportList.add(report);
        }

        return reportList;
    }
    }


