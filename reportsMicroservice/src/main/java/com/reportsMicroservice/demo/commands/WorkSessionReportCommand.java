package com.reportsMicroservice.demo.commands;

import com.reportsMicroservice.demo.dto.*;
import com.reportsMicroservice.demo.model.reports.WorkSessionReport;
import com.reportsMicroservice.demo.service.reports.ReportsService;

import java.util.List;

public class WorkSessionReportCommand implements Command {
    private ReportsService reportsService;
    private UserDTO user;
    private List<PMtoReportsProjectDTO> projects;
    private PMtoReportsClientDTO client;
    private List<PMtoReportsToDoDTO> PMtoReportsToDoDTOS;
    private List<TT_dto> trackTimeDTOS;


    public WorkSessionReportCommand(ReportsService reportsService, UserDTO user, List<PMtoReportsProjectDTO> projects, List<PMtoReportsToDoDTO> PMtoReportsToDoDTOS, List<TT_dto> trackTimeDTOS) {
        this.reportsService = reportsService;
        this.user = user;
        this.projects = projects;
        this.PMtoReportsToDoDTOS = PMtoReportsToDoDTOS;
        this.trackTimeDTOS = trackTimeDTOS;
    }

    @Override
    public void execute() {
        reportsService.generateWorkSessionReports(user, projects, PMtoReportsToDoDTOS, trackTimeDTOS);
    }
}


