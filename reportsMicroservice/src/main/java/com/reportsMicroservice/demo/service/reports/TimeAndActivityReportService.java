package com.reportsMicroservice.demo.service.reports;

import com.reportsMicroservice.demo.model.others.Project;
import com.reportsMicroservice.demo.model.others.Time_off;
import com.reportsMicroservice.demo.model.others.User;
import com.reportsMicroservice.demo.model.reports.ManualTimeEditReport;
import com.reportsMicroservice.demo.model.reports.TimeAndActivityReport;
import com.reportsMicroservice.demo.repository.others.PaymentRepository;
import com.reportsMicroservice.demo.repository.others.ProjectRepository;
import com.reportsMicroservice.demo.repository.others.Time_offRepository;
import com.reportsMicroservice.demo.repository.others.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

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

    public List<TimeAndActivityReport> generateTimeAndActivityReports() {
        List<TimeAndActivityReport> reportList = new ArrayList<>();

        List<User> users = userRepository.findAll();

        for (User user : users) {
            Project project = projectRepository.findById(user.getProjectId());
            if (project == null) {
                continue; // Skip users without associated projects
            }

            Time_off timeoff = timeOffRepository.findByUserId(user.getId());



            //project , member , regularHours , overtime , timeoff , totalHours , activity, manual, totalSpent, regularSpent
            TimeAndActivityReport report = new TimeAndActivityReport(
                    project.getProjectName(),
                    user.getFullName(),
                    0.0,
                    timeoff.calculateDuration(),
                    user.getTotalHoursWorked(),
                    "activity",
                    paymentRepository.findByUserId(user.getId()).getAmount()
            );
            reportList.add(report);
        }
        return reportList;
    }
}
