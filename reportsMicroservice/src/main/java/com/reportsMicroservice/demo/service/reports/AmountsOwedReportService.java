package com.reportsMicroservice.demo.service.reports;

import com.reportsMicroservice.demo.model.others.Timesheet_time;
import com.reportsMicroservice.demo.model.others.User;
import com.reportsMicroservice.demo.model.reports.AmountsOwedReport;
import com.reportsMicroservice.demo.repository.others.Timesheet_timeRepository;
import com.reportsMicroservice.demo.repository.others.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class AmountsOwedReportService {

    @Autowired
    private Timesheet_timeRepository Timesheet_timeRepository;
    @Autowired
    private UserRepository UserRepository;




    public List<AmountsOwedReport> generateAmountsOwedReport(Integer userId) {
        Optional<User> optionalUser = UserRepository.findById(userId);

        return optionalUser.map(user -> {
            List<Timesheet_time> timesheets = Timesheet_timeRepository.findByUserId(userId);
            if (timesheets.isEmpty()) {
                return Collections.<AmountsOwedReport>emptyList();  // Explicitly typing the returned list
            }

            double weeklyLimit = Math.max(user.getWeeklyLimit(), 40.0);
            double totalHours = timesheets.stream().mapToDouble(Timesheet_time::getDuration).sum();
            double regularHours = Math.min(totalHours, weeklyLimit);
            double overtimeHours = Math.max(0, totalHours - weeklyLimit);
            double amountOwed = regularHours * user.getHourlyRate() + overtimeHours * (user.getHourlyRate() * 1.5);

            AmountsOwedReport report = new AmountsOwedReport(
                    user.getFullName(), user.getEmail(), user.getJoinDate(),
                    user.getHourlyRate(), regularHours, overtimeHours,
                    totalHours, amountOwed);
            return Collections.singletonList(report);
        }).orElse(Collections.emptyList());
        }
    }