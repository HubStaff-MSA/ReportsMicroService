package com.reportsMicroservice.demo.service.reports;

import com.reportsMicroservice.demo.model.others.*;
import com.reportsMicroservice.demo.model.reports.TimeAndActivityReport;
import com.reportsMicroservice.demo.repository.others.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class TimeAndActivityReportService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private Time_offRepository timeOffRepository;

    @Autowired
    private ProjectRepository projectRepository;

    @Autowired
    private PaymentRepository paymentRepository;

    @Autowired
    private Timesheet_timeRepository timesheet_timeRepository;

    public List<TimeAndActivityReport> generateTimeAndActivityReports(Integer userId) {
        Optional<User> optionalUser = userRepository.findById(userId);
        if (!optionalUser.isPresent()) {
            return Collections.emptyList(); // Return empty list if user is not found
        }
        User user = optionalUser.get();

        Optional<Project> optionalProject = projectRepository.findById(user.getProjectId());
        if (!optionalProject.isPresent()) {
            return Collections.emptyList(); // Return empty list if project is not found
        }
        Project project = optionalProject.get();

        Time_off timeOff = timeOffRepository.findByUserId(user.getId());
        double timeOffDuration = (timeOff != null) ? timeOff.calculateDuration() : 0.0;

        List<Timesheet_time> timesheets = timesheet_timeRepository.findByUserId(userId);
        double totalHours = timesheets.stream()
                .mapToDouble(Timesheet_time::getDuration)
                .sum();
        double regularHours = Math.min(totalHours, user.getWeeklyLimit());
        double overtime = Math.max(0, totalHours - user.getWeeklyLimit());

        List<Payment> payments = paymentRepository.findByUserId(user.getId());
        double totalSpent = payments.stream()
                .mapToDouble(Payment::getAmount)
                .sum();

        TimeAndActivityReport report = new TimeAndActivityReport(
                project.getProjectName(),
                user.getFullName(),
                regularHours,
                overtime,
                timeOffDuration,
                totalHours,
                    "Description Test", // Placeholder or fetch from a real source
                totalHours, // Assuming manualHours are equivalent to totalHours; adjust as necessary
                totalSpent,
                regularHours * user.getHourlyRate() // Assuming regularSpent is calculated like this
        );

        return Collections.singletonList(report);
    }
}
