package com.reportsMicroservice.demo.service.reports;

import com.reportsMicroservice.demo.model.others.*;
import com.reportsMicroservice.demo.model.reports.TimeOffTransactionReport;
import com.reportsMicroservice.demo.model.reports.WorkSessionReport;
import com.reportsMicroservice.demo.repository.others.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class TimeOffTransactionReportService {
    @Autowired
    private ClientRepository clientRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private Time_offRepository timeOffRepository;

    //policy, requestedOn , start, end, type, reason, approvedBy, changedBy, duration

    public List<TimeOffTransactionReport> generateTimeOffTransactionReports() {
        List<TimeOffTransactionReport> reportList = new ArrayList<>();

        List<User> users = userRepository.findAll();


        for (User user : users) {
            Time_off timeoff = timeOffRepository.findByUserId(user.getId());
            Integer approvedByUserId = timeoff.getApprovedByUserId();
            Integer changedByUserId = timeoff.getChangedByUserId();

            User approvedBy = userRepository.findById(approvedByUserId);
            User changedBy = userRepository.findById(changedByUserId);

            LocalDate currentDate = LocalDate.now();

            TimeOffTransactionReport report = new TimeOffTransactionReport(
                    timeoff.getPolicy(),
                    currentDate, //requestedOn
                    timeoff.getStartDate(),
                    timeoff.getEndDate(),
                    timeoff.getType(),
                    timeoff.getReason(),
                    approvedBy.getFullName(),
                    changedBy.getFullName(),
                    timeoff.calculateDuration());

            reportList.add(report);

        }


        return reportList;
    }



}
