package com.reportsMicroservice.demo.service.reports;

import com.reportsMicroservice.demo.model.others.Timesheet_time;
import com.reportsMicroservice.demo.model.others.User;
import com.reportsMicroservice.demo.model.reports.AmountsOwedReport;
import com.reportsMicroservice.demo.repository.others.Timesheet_timeRepository;
import com.reportsMicroservice.demo.repository.others.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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


    public List<AmountsOwedReport> generateAmountsOwedReport() {
        List<Timesheet_time> timesheets = Timesheet_timeRepository.findAll(); // Fetch all timesheets

        Map<Integer, List<Timesheet_time>> groupedTimesheets = timesheets.stream()
                .collect(Collectors.groupingBy(Timesheet_time::getUserId));

        return groupedTimesheets.entrySet().stream().map(entry -> {
            Optional<User> optionalUser = Optional.ofNullable(UserRepository.findById(entry.getKey()));
            if (optionalUser.isPresent()) {
                User user = optionalUser.get();

                double weeklyLimit = user.getWeeklyLimit() != 0 ? user.getWeeklyLimit() : 40.0; // Default to 40 if not specified
                double totalHours = entry.getValue().stream().mapToDouble(this::getTotalHours).sum();
                double regularHours = Math.min(totalHours, weeklyLimit);
                double overtimeHours = Math.max(0, totalHours - weeklyLimit);

                double amountOwed = regularHours * user.getHourlyRate() +
                        overtimeHours * (user.getHourlyRate() * 1.5);

                return new AmountsOwedReport(
                        user.getFullName(), user.getEmail(), user.getJoinDate(),
                        user.getHourlyRate(), regularHours, overtimeHours,
                        totalHours, amountOwed);
            } else {
                return null; // User with the specified ID was not found
            }
        }).filter(Objects::nonNull).collect(Collectors.toList());
    }

    private double getTotalHours(Timesheet_time timesheet) {
        // Implement logic to calculate total hours from Timesheet_time object
        return timesheet.getDuration(); // Example method to calculate duration
    }


}
