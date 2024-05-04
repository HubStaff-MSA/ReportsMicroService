package com.reportsMicroservice.demo.service;

import com.reportsMicroservice.demo.model.WorkSessionReport;
import com.reportsMicroservice.demo.repository.WorkSessionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WorkSessionService {
    @Autowired
    private WorkSessionRepository workSessionReportRepository;

    public List<WorkSessionReport> getAllWorkSessionReports() {
        return workSessionReportRepository.getAllWorkSessionReports();
    }

    public List<WorkSessionReport> getWorkSessionsByEmployeeId(Long employeeId) {
        return workSessionReportRepository.findByMemberId(employeeId);
    }
}
