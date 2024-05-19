package com.reportsMicroservice.demo.service.reports;

import com.reportsMicroservice.demo.model.others.*;
import com.reportsMicroservice.demo.model.reports.WorkSessionReport;
import com.reportsMicroservice.demo.repository.others.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


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


    public List<WorkSessionReport> generateWorkSessionReports(Integer userId) {
        List<WorkSessionReport> reportList = new ArrayList<>();
        Optional<User> userOptional = userRepository.findById(userId);

        if (!userOptional.isPresent()) {
            return reportList;  // Return empty list if user is not found
        }

        User user = userOptional.get();
        Optional<Project> projectOptional = projectRepository.findById(user.getProjectId());
        if (!projectOptional.isPresent()) {
            return reportList;  // Return empty list if project is not found
        }

        Project project = projectOptional.get();
        Optional<Client> clientOptional = clientRepository.findById(project.getClientId());
        if (!clientOptional.isPresent()) {
            return reportList;  // Return empty list if client is not found
        }

        Client client = clientOptional.get();
        List<ToDo> todos = toDoRepository.findByUserId(userId);  // Assume this returns a list
        List<Timesheet_time> timesheets = timesheetRepository.findByUserId(userId);

        // Process each combination of timesheet and todo
        for (Timesheet_time timesheet : timesheets) {
            for (ToDo toDo : todos) {
                WorkSessionReport report = new WorkSessionReport(
                        client.getName(),
                        project.getProjectName(),
                        user.getFullName(),
                        toDo.getContent(),
                        timesheet.isManual(),
                        timesheet.getStartTime(),
                        timesheet.getEndTime(),
                        timesheet.getDuration());

                reportList.add(report);
            }
        }

        return reportList;
    }

}


