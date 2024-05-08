package com.reportsMicroservice.demo.service.reports;

import com.reportsMicroservice.demo.model.others.*;
import com.reportsMicroservice.demo.model.reports.WorkSessionReport;
import com.reportsMicroservice.demo.repository.others.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    public WorkSessionReport generateWorkSessionReportByUserId(Integer userId) {
        User user = userRepository.findById(userId);
        if (user == null) {
            throw new IllegalArgumentException("User not found");
        }

        // Assuming the user is associated with a single project for simplicity
        Project project = projectRepository.findById(user.getProjectId());
        Client client = clientRepository.findById(project.getClientId());

        // The user's name, since the report is specific to this user
        String memberName = user.getFullName();

        // Fetching ToDos and Timesheets specific to this user
        ToDo toDo = toDoRepository.findByUserId(userId);
        Timesheet_time timesheets = timesheetRepository.findByUserId(userId);

        return new WorkSessionReport(client.getName(), project.getProjectName(), memberName,toDo.getContent(), timesheets.isManual(),timesheets.getStartTime(),timesheets.getEndTime(),timesheets.calculateDurationInHours());
    }
    }


