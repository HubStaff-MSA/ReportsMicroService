package com.reportsMicroservice.demo.service;

import com.reportsMicroservice.demo.model.Timesheet_time;
import com.reportsMicroservice.demo.model.WorkSessionReport;
import com.reportsMicroservice.demo.repository.Timesheet_timeRepository;
import com.reportsMicroservice.demo.repository.WorkSessionReportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class WorkSessionReportService {

    private final Timesheet_timeRepository timesheetTimeRepository; // Assuming you have a repository for Timesheet_time

    public WorkSessionReportService(Timesheet_timeRepository timesheetTimeRepository) {
        this.timesheetTimeRepository = timesheetTimeRepository;
    }

//    public List<WorkSessionReport> generateWorkSessionReport() {
//        List<Timesheet_time> timesheetEntries = timesheetTimeRepository.findAll(); // Retrieve all timesheet entries
//
//        return timesheetEntries.stream()
//                .map(this::mapToWorkSessionReportDTO)
//                .collect(Collectors.toList());
//    }

//    private WorkSessionReport mapToWorkSessionReportDTO(Timesheet_time timesheetTime) {
//        WorkSessionReport dto = new WorkSessionReport();
//        dto.setClientName(timesheetTime.getProject().getClient().getName());
//        dto.setProjectName(timesheetTime.getProject().getProjectName());
//        dto.setMemberName(getMemberNameById(timesheetTime.getMemberId())); // Implement this method
//        dto.setTodoDescription(timesheetTime.getTodo().getDescription()); // Assuming you have Todo entity with description
//        dto.setManual(timesheetTime.isManual());
//        dto.setStartTime(timesheetTime.getStartTime());
//        dto.setEndTime(timesheetTime.getEndTime());
//        dto.setDuration(Duration.between(timesheetTime.getStartTime(), timesheetTime.getEndTime()));
//        dto.setActivity(timesheetTime.getAction().toString());
//
//        return dto;
//    }

    private String getMemberNameById(Long memberId) {
        // Implement a method to fetch member name based on memberId
        // Example: Member member = memberRepository.findById(memberId).orElse(null);
        // Return member.getName() if member is found
        return ""; // Placeholder implementation
    }
}
