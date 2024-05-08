package com.reportsMicroservice.demo.service;

import com.reportsMicroservice.demo.model.*;
import com.reportsMicroservice.demo.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


@Service
public class WorkSessionReportService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private Timesheet_timeRepository timesheetRepository;

    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private ProjectRepository projectRepository;

    @Autowired
    private ToDoRepository todoRepository;

    private static final Logger logger = LoggerFactory.getLogger(WorkSessionReportService.class);


    public List<WorkSessionReport> generateReport() {
        logger.debug("Generating work session report...");
        List<Timesheet_time> timesheetList = timesheetRepository.findAll();
        logger.debug("Found {} timesheet entries", timesheetList.size());

        return timesheetList.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    private WorkSessionReport convertToDTO(Timesheet_time timesheet) {
        logger.debug("Converting Timesheet_time to WorkSessionReport for timesheet_id: {}", timesheet.getTimesheetId());
        WorkSessionReport dto = new WorkSessionReport();

        Integer projectId = timesheet.getProjectId();
        logger.debug("Retrieving project details for projectId: {}", projectId);

        Optional<Project> projectOptional = projectRepository.findById(projectId);
        if (projectOptional.isPresent()) {
            Project project = projectOptional.get();
            dto.setProjectName(project.getProjectName());
            dto.setClientName(getClientNameByProjectId(projectId));
        } else {
            dto.setProjectName("Unknown Project");
            dto.setClientName("Unknown Client");
        }

        dto.setMemberName(getEmployeeFullName(timesheet));
        dto.setTodo(getTodoContentById(timesheet.getTodoId()));
        dto.setManual(timesheet.isManual());
        dto.setStartTime(timesheet.getStartTime());
        dto.setEndTime(timesheet.getEndTime());
        dto.setDuration(timesheet.getDuration());
        dto.setActivity(timesheet.getAction().toString());

        return dto;
    }

    private String getClientNameByProjectId(Integer projectId) {
        Optional<Project> projectOptional = projectRepository.findById(projectId);
        if (projectOptional.isPresent()) {
            Project project = projectOptional.get();
            Integer clientId = project.getClientId();
            logger.debug("Retrieving client details for clientId: {}", clientId);
            Optional<Client> clientOptional = clientRepository.findById(clientId);
            return clientOptional.map(Client::getName).orElse("Unknown Client");
        }
        return "Unknown Client";
    }

    private String getTodoContentById(Integer todoId) {
        logger.debug("Retrieving TODO  details for todoId: {}", todoId);
        return todoRepository.findById(todoId).map(ToDo::getContent).orElse("Unknown Todo");
    }

    private String getEmployeeFullName(Timesheet_time timesheet) {
        Integer employeeId = timesheet.getUserId();
        logger.debug("Retrieving user details for userId: {}", employeeId);
        return userRepository.findById(employeeId).map(User::getFullName).orElse("Unknown User");
    }
}
