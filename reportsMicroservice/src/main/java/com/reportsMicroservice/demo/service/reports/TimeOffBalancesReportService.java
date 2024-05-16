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
import java.util.List;

@Service
public class TimeOffBalancesReportService {
    @Autowired
    private Time_offRepository timeOffRepository;
    @Autowired
    private UserRepository userRepository;

    //policy , used, pending, balance, reason
    public List<TimeOffBalancesReport> generateTimeOffTransactionReports() {
        List<TimeOffBalancesReport> reportList = new ArrayList<>();
        List<User> users = userRepository.findAll();

        for(User user: users){
            Time_off timeoff = timeOffRepository.findByUserId(user.getId());

            TimeOffBalancesReport report = new TimeOffBalancesReport(
              timeoff.getPolicy(),
                    user.getUsedTimeOff(),
                    user.getPendingTimeOff(),
                    user.getBalanceTimeOff(),
              timeoff.getReason());

            reportList.add(report);
        }

        return reportList;
    }

}
