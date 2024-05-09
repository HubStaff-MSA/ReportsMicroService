package com.reportsMicroservice.demo.service.reports;

import com.reportsMicroservice.demo.model.others.Timesheet_time;
import com.reportsMicroservice.demo.model.others.User;
import com.reportsMicroservice.demo.model.reports.AmountsOwedReport;
import com.reportsMicroservice.demo.repository.others.Timesheet_timeRepository;
import com.reportsMicroservice.demo.repository.others.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AmountsOwedReportService {

    @Autowired
    private Timesheet_timeRepository Timesheet_timeRepository;
    @Autowired
    private UserRepository UserRepository;
    private double getTotalHours(Timesheet_time timesheet) {
        long minutes = java.time.Duration.between(timesheet.getStartTime(), timesheet.getEndTime()).toMinutes();
        return minutes / 60.0;
    }

    public List<AmountsOwedReport> generateAmountsOwedReport(LocalDate from, LocalDate to) {
        List<Timesheet_time> timesheets = Timesheet_timeRepository.findByDateRange(from, to);
        Map<Integer, List<Timesheet_time>> groupedTimesheets = timesheets.stream()
                .collect(Collectors.groupingBy(Timesheet_time::getUserId));

        return groupedTimesheets.entrySet().stream().map(entry -> {
            Optional<User> optionalUser = Optional.ofNullable(UserRepository.findById(entry.getKey()));
            if (optionalUser.isPresent()) {
                User user = optionalUser.get();

                double weeklyLimit = user.getWeeklyLimit() != null ? user.getWeeklyLimit().doubleValue() : 40.0; // Default to 40 if not specified
                double totalHours = entry.getValue().stream().mapToDouble(this::getTotalHours).sum();
                double regularHours = Math.min(totalHours, weeklyLimit);
                double overtimeHours = Math.max(0, totalHours - weeklyLimit);

                double amountOwed = regularHours * user.getHourlyRate().doubleValue() +
                        overtimeHours * (user.getHourlyRate().doubleValue() * 1.5);

                return new AmountsOwedReport(
                        user.getFullName(), user.getEmail(), user.getJoinDate(),
                        user.getHourlyRate().doubleValue(), regularHours, overtimeHours,
                        totalHours, amountOwed);
            } else {
                return null; // User with the specified ID was not found
            }
        }).filter(Objects::nonNull).collect(Collectors.toList());
    }





}
