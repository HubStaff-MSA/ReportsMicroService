package com.reportsMicroservice.demo.service;

import com.reportsMicroservice.demo.model.Employee;
import com.reportsMicroservice.demo.model.Timesheet_time;
import com.reportsMicroservice.demo.model.WorkSessionReport;
import com.reportsMicroservice.demo.repository.Timesheet_timeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class WorkSessionReportService {

    @Autowired
    private Timesheet_timeRepository timesheetRepository;

    public List<WorkSessionReport> generateReport() {
        List<Timesheet_time> timesheet = timesheetRepository.findAll(); // Or use a custom query to fetch relevant data
        return timesheet.stream().map(this::convertToDTO).collect(Collectors.toList());
    }

    private WorkSessionReport convertToDTO(Timesheet_time timesheet) {
        WorkSessionReport dto = new WorkSessionReport();
        // Assuming that Timesheet_time references User and Employee correctly
        Employee employee = (Employee) timesheet.getEmployee(); // This casting assumes every User in Timesheet_time is an Employee
        String fullName = employee != null ? employee.getFirstName() + " " + employee.getLastName() : "Unknown User";

        dto.setClientName(timesheet.getProject().getClient().getName());
        dto.setProjectName(timesheet.getProject().getProjectName());
        dto.setMemberName(fullName); // Adjust naming if needed
        dto.setTodo(timesheet.getTodo().getContent());
        dto.setManual(timesheet.isManual());
        dto.setStartTime(timesheet.getStartTime());
        dto.setEndTime(timesheet.getEndTime());
        dto.setDuration(timesheet.getDuration());
        dto.setActivity(timesheet.getAction().toString()); // Assuming 'action' represents activity level
        return dto;
    }
}
