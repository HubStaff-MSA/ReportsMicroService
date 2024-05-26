package com.reportsMicroservice.demo.commands.webserver;

import com.reportsMicroservice.demo.MQPublisher.RabbitMQListenerPublisher;
import com.reportsMicroservice.demo.MQPublisher.RabbitMQServicePublisher;
import com.reportsMicroservice.demo.commands.Command;
import com.reportsMicroservice.demo.commands.CommandInvoker;
import com.reportsMicroservice.demo.dto.*;
import com.reportsMicroservice.demo.model.reports.WorkSessionReport;
import com.reportsMicroservice.demo.service.reports.ReportsService;
import org.springframework.amqp.rabbit.core.RabbitTemplate;

import java.util.List;

public class WebServer_WorkSession implements Command {

    private String id;
    private final RabbitTemplate rabbitTemplate;

    private final ReportsService reportsService;

    private List<WorkSessionReport> returnedValue;



    public WebServer_WorkSession(String id,
                                 RabbitTemplate rabbitTemplate,
                                 ReportsService reportsService) {
        this.id = id;
        this.rabbitTemplate = rabbitTemplate;
        this.reportsService = reportsService;
    }


    @Override
    public void execute() {

        CommandSender command = new CommandSender("GetUser", id,
                "U_R_Queue");
        //rabbitMQServicePublisher.sendMessage("commandQueueUser", command);
        UserDTO user = (UserDTO) rabbitTemplate.convertSendAndReceive("WebServerUserQueue", command);

        //command for time track
        CommandSender command2 = new CommandSender("ListOfTimeTracksByUsersIds", List.of(id),
                "TT_R_Queue");
        //rabbitMQServicePublisher.sendMessage("commandQueueTimeTracking", command2);
        List<TT_dto> trackTimes = (List<TT_dto>) rabbitTemplate.convertSendAndReceive("commandQueueTimeTracking", command2);

        //command for projects
        CommandSender command3 = new CommandSender("getProjectsByUserIdCommand", id,
                "P_R_Projects_Queue");
        //rabbitMQServicePublisher.sendMessage("commandQueueProjects", command3);
        List<PMtoReportsProjectDTO> projects = (List<PMtoReportsProjectDTO>) rabbitTemplate.convertSendAndReceive("webServerCommandQueueProjects", command3);

        //command for to do
        CommandSender command5 = new CommandSender("getToDosByUserId", id,
                "P_R_ToDos_Queue");
        //rabbitMQServicePublisher.sendMessage("commandQueueProjects", command5);
        List<PMtoReportsToDoDTO> todos = (List<PMtoReportsToDoDTO>) rabbitTemplate.convertSendAndReceive("webServerCommandQueueProjects", command5);


        returnedValue = reportsService.generateWorkSessionReports(user, projects, todos, trackTimes);
    }






}
