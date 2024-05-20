package com.reportsMicroservice.demo.service.reports;

import com.reportsMicroservice.demo.model.others.Time_off;
import com.reportsMicroservice.demo.model.others.User;
import com.reportsMicroservice.demo.model.reports.TimeOffBalancesReport;
import com.reportsMicroservice.demo.model.reports.TimeOffTransactionReport;
import com.reportsMicroservice.demo.repository.others.Time_offRepository;
import com.reportsMicroservice.demo.repository.others.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class TimeOffBalancesReportService {
    @Autowired
    private Time_offRepository timeOffRepository;
    @Autowired
    private UserRepository userRepository;

    //policy , used, pending, balance, reason
    public List<TimeOffBalancesReport> generateTimeOffTransactionReports(Integer userId) {
        Optional<User> optionalUser = userRepository.findById(userId);
        if (!optionalUser.isPresent()) {
            return Collections.emptyList(); // Return empty list if the user is not found
        }
        User user = optionalUser.get();

        Time_off timeOff = timeOffRepository.findByUserId(user.getId());
        if (timeOff == null) {
            return Collections.emptyList(); // Return empty list if no time off records are found for the user
        }

        // Create a time off transaction report for the user
        TimeOffBalancesReport report = new TimeOffBalancesReport(
                timeOff.getPolicy(),
                user.getUsedTimeOff(),
                user.getPendingTimeOff(),
                user.getBalanceTimeOff(),
                timeOff.getReason()
        );

        return Collections.singletonList(report); // Return a list containing only this report
    }

}
