package com.reportsMicroservice.demo.commands;

import com.reportsMicroservice.demo.dto.*;
import com.reportsMicroservice.demo.service.reports.ReportsService;

import java.util.List;

public class WorkSessionReportCommand implements Command {
    private ReportsService reportsService;
    private UserDTO user;
    private List<ProjectDTO> projects;
    private ClientDTO client;
    private List<ToDoDTO> toDoDTOS;
    private List<TrackTimeDTO> trackTimeDTOS;

    public WorkSessionReportCommand(ReportsService reportsService, UserDTO user, List<ProjectDTO> projects, ClientDTO client, List<ToDoDTO> toDoDTOS, List<TrackTimeDTO> trackTimeDTOS) {
        this.reportsService = reportsService;
        this.user = user;
        this.projects = projects;
        this.client = client;
        this.toDoDTOS = toDoDTOS;
        this.trackTimeDTOS = trackTimeDTOS;
    }

    @Override
    public void execute() {
        reportsService.generateWorkSessionReports(user, projects, client, toDoDTOS, trackTimeDTOS);
    }
}


