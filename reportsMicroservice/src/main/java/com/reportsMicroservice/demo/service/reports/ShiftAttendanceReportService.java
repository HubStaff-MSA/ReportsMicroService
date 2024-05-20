package com.reportsMicroservice.demo.service.reports;

import com.reportsMicroservice.demo.model.others.Shift;
import com.reportsMicroservice.demo.model.others.User;
import com.reportsMicroservice.demo.model.reports.ShiftAttendanceReport;
import com.reportsMicroservice.demo.repository.others.ShiftRepository;
import com.reportsMicroservice.demo.repository.others.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;


@Service
public class ShiftAttendanceReportService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ShiftRepository shiftRepository;


    public List<ShiftAttendanceReport> generateShiftAttendanceReports(Integer userId) {
        Optional<User> optionalUser = userRepository.findById(userId);
        if (!optionalUser.isPresent()) {
            return Collections.emptyList(); // Return empty list if user is not found
        }
        User user = optionalUser.get();

        Shift shift = shiftRepository.findByUserId(user.getId());
        if (shift == null) {
            return Collections.emptyList(); // Return empty list if no shift is found
        }

        // Create a shift attendance report
        ShiftAttendanceReport report = new ShiftAttendanceReport(
                user.getFullName(),
                shift.getIssueStatus(),
                shift.getStartDatetime().toString() + " - " + shift.getEndDatetime().toString(),
                shift.getStartDatetime().toLocalTime(),
                shift.getMinimumHours(),
                user.getTotalHoursWorked()
        );

        return Collections.singletonList(report); // Return a list containing only this report
    }

}