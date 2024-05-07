package com.reportsMicroservice.demo.service;
import com.reportsMicroservice.demo.model.Timesheet_time;
import com.reportsMicroservice.demo.model.WorkSessionReport;
import com.reportsMicroservice.demo.repository.Timesheet_timeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.junit.runner.RunWith;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class WorkSessionReportServiceIntegrationTest {

    @Autowired
    private WorkSessionReportService reportService;

    @Autowired
    private Timesheet_timeRepository timesheetRepository;

    @Test
    public void testReportGeneration() {
        // Setup data - ensure there are Timesheet_time entries in the database
        Timesheet_time timesheet = new Timesheet_time(); // appropriately initialize this object
        timesheetRepository.save(timesheet);

        // Execute
        List<WorkSessionReport> reports = reportService.generateReport();
        System.out.println("Reports: " + reports);

        // Verify
        assertFalse("Report should not be empty", reports.isEmpty());
    }
}
