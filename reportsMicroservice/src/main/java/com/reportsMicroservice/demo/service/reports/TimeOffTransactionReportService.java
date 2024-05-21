package com.reportsMicroservice.demo.service.reports;

import com.reportsMicroservice.demo.model.others.*;
import com.reportsMicroservice.demo.model.reports.TimeOffTransactionReport;
import com.reportsMicroservice.demo.model.reports.WorkSessionReport;
import com.reportsMicroservice.demo.repository.others.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class TimeOffTransactionReportService {
    @Autowired
    private ClientRepository clientRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private Time_offRepository timeOffRepository;


    //policy, requestedOn , start, end, type, reason, approvedBy, changedBy, duration

    public List<TimeOffTransactionReport> generateTimeOffTransactionReports(Integer userId) {
        Optional<User> optionalUser = userRepository.findById(userId);
        if (!optionalUser.isPresent()) {
            return Collections.emptyList(); // Return empty list if the user is not found
        }
        User user = optionalUser.get();

        Time_off timeoff = timeOffRepository.findByUserId(user.getId());
        if (timeoff == null) {
            return Collections.emptyList(); // Return empty list if no time off records are found for the user
        }

        Optional<User> approvedByUser = userRepository.findById(timeoff.getApprovedByUserId());
        Optional<User> changedByUser = userRepository.findById(timeoff.getChangedByUserId());

        LocalDate currentDate = LocalDate.now();

        TimeOffTransactionReport report = new TimeOffTransactionReport(
                timeoff.getPolicy(),
                currentDate, // Assuming the 'requestedOn' date needs to be the current date
                timeoff.getStartDate(),
                timeoff.getEndDate(),
                timeoff.getType(),
                timeoff.getReason(),
                approvedByUser.map(User::getFullName).orElse("UserTest"),
                changedByUser.map(User::getFullName).orElse("UserTest"),
                timeoff.calculateDuration());

        return Collections.singletonList(report);
    }


}
