package com.reportsMicroservice.demo.service.reports;

import com.reportsMicroservice.demo.model.others.User;
import com.reportsMicroservice.demo.model.reports.WeeklyLimitReport;
import com.reportsMicroservice.demo.repository.others.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class WeeklyLimitReportService {

    @Autowired
    private UserRepository userRepository;

    // Method to generate weekly limit report for all users
    public List<WeeklyLimitReport> generateWeeklyLimitReport(Integer userID) {
        List<WeeklyLimitReport> reportList = new ArrayList<>();

        Optional<User> optionalUser = userRepository.findById(userID);
        if (optionalUser.isPresent()) {
            User user = optionalUser.get();
            if (user.getWeeklyLimit() > 0) {
                double totalHoursWorked = user.getTotalHoursWorked();
                double weeklyLimit = user.getWeeklyLimit();

                WeeklyLimitReport report = new WeeklyLimitReport(
                        user.getId(),
                        user.getFullName(),
                        totalHoursWorked,
                        weeklyLimit,
                        calculatePercentageUsed(totalHoursWorked, weeklyLimit),
                        calculateRemainingHours(totalHoursWorked, weeklyLimit));

                reportList.add(report);
            }
        }

        return reportList;
    }

    private double calculatePercentageUsed(double totalHoursWorked, double weeklyLimit) {
        if (weeklyLimit > 0) {
            return (totalHoursWorked / weeklyLimit) * 100.0;
        } else {
            return 0.0;
        }
    }

    // Helper method to calculate remaining hours within weekly limit
    private double calculateRemainingHours(double totalHoursWorked, double weeklyLimit) {
        return Math.max(weeklyLimit - totalHoursWorked, 0.0);
    }
}
