package com.reportsMicroservice.demo.service.reports;

import com.reportsMicroservice.demo.model.others.Shift;
import com.reportsMicroservice.demo.model.others.User;
import com.reportsMicroservice.demo.model.reports.ShiftAttendanceReport;
import com.reportsMicroservice.demo.repository.others.ShiftRepository;
import com.reportsMicroservice.demo.repository.others.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class ShiftAttendanceReportService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ShiftRepository shiftRepository;


    public List<ShiftAttendanceReport> generateShiftAttendanceReports() {
        List<ShiftAttendanceReport> reportList = new ArrayList<>();

        List<User> users = userRepository.findAll();



        for (User user : users) {
            Shift shift = shiftRepository.findByUserId(user.getId());


            // member, issue, shift, startTime, requiredHrs, actualHrs
            ShiftAttendanceReport report = new ShiftAttendanceReport(
                    user.getFullName(),
                    shift.getIssueStatus(),
                    shift.getStartDatetime().toString() + "   -  " + shift.getEndDatetime().toString(),
                    shift.getStartDatetime().toLocalTime(),
                    shift.getMinimumHours(),
                    user.getTotalHoursWorked()

            );
            reportList.add(report);
        }
        return reportList;
    }


}