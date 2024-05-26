package com.reportsMicroservice.demo.controller;

import com.reportsMicroservice.demo.MQPublisher.RabbitMQServicePublisher;
import com.reportsMicroservice.demo.dto.CommandSender;
import com.reportsMicroservice.demo.model.reports.*;
import com.reportsMicroservice.demo.repository.reports.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/api/reports")
public class ReportsController {

    private final RabbitMQServicePublisher rabbitMQServicePublisher;
    private final WorkSessionReportRepository workSessionReportRepository;
    private final TimeAndActivityReportRepository timeAndActivityReportRepository;
    private final WeeklyLimitReportRepository weeklyLimitReportRepository;
    private final ProjectBudgetsReportRepository projectBudgetsReportRepository;
    private final ClientBudgetsReportRepository clientBudgetsReportRepository;
    private final PaymentsReportRepository paymentsReportRepository;
    private final AmountsOwedReportRepository amountsOwedReportRepository;

    @Autowired
    public ReportsController(RabbitMQServicePublisher rabbitMQServicePublisher, WorkSessionReportRepository workSessionReportRepository, TimeAndActivityReportRepository timeAndActivityReportRepository, WeeklyLimitReportRepository weeklyLimitReportRepository, ProjectBudgetsReportRepository projectBudgetsReportRepository, ClientBudgetsReportRepository clientBudgetsReportRepository, PaymentsReportRepository paymentsReportRepository, AmountsOwedReportRepository amountsOwedReportRepository) {
        this.rabbitMQServicePublisher = rabbitMQServicePublisher;
        this.workSessionReportRepository = workSessionReportRepository;
        this.timeAndActivityReportRepository = timeAndActivityReportRepository;
        this.weeklyLimitReportRepository = weeklyLimitReportRepository;
        this.projectBudgetsReportRepository = projectBudgetsReportRepository;
        this.clientBudgetsReportRepository = clientBudgetsReportRepository;
        this.paymentsReportRepository = paymentsReportRepository;
        this.amountsOwedReportRepository = amountsOwedReportRepository;
    }

    @GetMapping("/work-session/{id}")
    public String requestWorkSessionReport(@PathVariable String id) {
        //command for user
        CommandSender command = new CommandSender("GetUser", id,
                "U_R_Queue");
        rabbitMQServicePublisher.sendMessage("commandQueueUser", command);

        //command for time track
        CommandSender command2 = new CommandSender("ListOfTimeTracksByUsersIds", List.of(id),
                "TT_R_Queue");
        rabbitMQServicePublisher.sendMessage("commandQueueTimeTracking", command2);

        //command for projects
        CommandSender command3 = new CommandSender("getProjectsByUserIdCommand", id,
                "P_R_Projects_Queue");
        rabbitMQServicePublisher.sendMessage("commandQueueProjects", command3);

        //command for to do
        CommandSender command5 = new CommandSender("getToDosByUserId", id,
                "P_R_ToDos_Queue");
        rabbitMQServicePublisher.sendMessage("commandQueueProjects", command5);

        return "Request for work session report sent for U_R_Queue, TT_R_Queue, P_R_Projects_Queue, P_R_Clients_Queue & P_R_ToDos_Queue";
    }

    @GetMapping("/time-activity/{id}")
    public String requestTimeAndActivityReport(@PathVariable String id) {
        //User
        CommandSender command = new CommandSender("GetUser", id,
                "U_R_Queue");
        rabbitMQServicePublisher.sendMessage("commandQueueUser", command);

        //List of time tracks
        CommandSender command2 = new CommandSender("ListOfTimeTracksByUsersIds", List.of(id),
                "TT_R_Queue");
        rabbitMQServicePublisher.sendMessage("commandQueueTimeTracking", command2);

        //List of projects
        CommandSender command3 = new CommandSender("getProjectsByUserIdCommand", id,
                "P_R_Projects_Queue");
        rabbitMQServicePublisher.sendMessage("commandQueueProjects", command3);

        //List of payments
        CommandSender command4 = new CommandSender("getTotalAmountPerMember", id,
                "F_R_Queue");
        rabbitMQServicePublisher.sendMessage("commandQueueFinance", command4);

        return "Request for time and activity report sent for U_R_Queue, TT_R_Queue, P_R_Projects_Queue & F_R_Queue";
    }

    @GetMapping("/weekly-limit/{id}")
    public String requestWeeklyLimitReport(@PathVariable String id) {
        CommandSender command = new CommandSender("GetUser", id,
                "U_R_Queue");
        rabbitMQServicePublisher.sendMessage("commandQueueUser", command);
        return "Request for weekly limit report sent for U_R_Queue";
    }

    @GetMapping("/project-budgets/{projectId}")
    public String requestProjectBudgetsReport(@PathVariable String projectId) {
        CommandSender command = new CommandSender("getProject", projectId,
                "P_R_Projects_Queue");
        rabbitMQServicePublisher.sendMessage("commandQueueProjects", command);

        //List of payments by project
        CommandSender command2 = new CommandSender("getTotalAmountPerProject", projectId,
                "F_R_Queue");
        rabbitMQServicePublisher.sendMessage("commandQueueFinance", command2);

        return "Request for project budgets report sent for P_R_Projects_Queue & F_R_Queue";
    }

    @GetMapping("/client-budgets/{clientId}")
    public String requestClientBudgetsReport(@PathVariable String clientId) {
        CommandSender command = new CommandSender("getClientCommand", clientId,
                "P_R_Clients_Queue");
        rabbitMQServicePublisher.sendMessage("commandQueueProjects", command);

        //List of payments by client
        CommandSender command2 = new CommandSender("getTotalAmountByPayerId", clientId,
                "F_R_Queue");
        rabbitMQServicePublisher.sendMessage("commandQueueFinance", command2);

        return "Request for client budgets report sent for P_R_Clients_Queue & F_R_Queue";
    }

    @GetMapping("/payments/{id}")
    public String requestPaymentsReport(@PathVariable String id) {
        CommandSender command = new CommandSender("GetUser", id,
                "U_R_Queue");
        rabbitMQServicePublisher.sendMessage("commandQueueUser", command);

        //List of payments
        CommandSender command2 = new CommandSender("getTotalAmountPerMember", id,
                "F_R_Queue");
        rabbitMQServicePublisher.sendMessage("commandQueueFinance", command2);

        return "Request for payments report sent for U_R_Queue & F_R_Queue";
    }

    //Amounts owed report
    @GetMapping("/amounts-owed/{id}")
    public String requestAmountsOwedReport(@PathVariable String id) {
        CommandSender command = new CommandSender("GetUser", id,
                "U_R_Queue");
        rabbitMQServicePublisher.sendMessage("commandQueueUser", command);

        //List of payments
        CommandSender command2 = new CommandSender("ListOfTimeTracksByUsersIds", id,
                "TT_R_Queue");
        rabbitMQServicePublisher.sendMessage("commandQueueTimeTracking", command2);

        return "Request for amounts owed report sent for U_R_Queue & TT_R_Queue";
    }

    @GetMapping("/work-session")
    public List<WorkSessionReport> getAllWorkSessionReports() {
        return workSessionReportRepository.findAll();
    }

    @GetMapping("/time-activity")
    public List<TimeAndActivityReport> getAllTimeAndActivityReports() {
        return timeAndActivityReportRepository.findAll();
    }

    @GetMapping("/weekly-limit")
    public List<WeeklyLimitReport> getAllWeeklyLimitReports() {
        return weeklyLimitReportRepository.findAll();
    }

    @GetMapping("/project-budgets")
    public List<ProjectBudgetsReport> getAllProjectBudgetsReports() {
        return projectBudgetsReportRepository.findAll();
    }

    @GetMapping("/client-budgets")
    public List<ClientBudgetsReport> getAllClientBudgetsReports() {
        return clientBudgetsReportRepository.findAll();
    }

    @GetMapping("/payments")
    public List<PaymentsReport> getAllPaymentsReports() {
        return paymentsReportRepository.findAll();
    }

    @GetMapping("/amounts-owed")
    public List<AmountsOwedReport> getAllAmountsOwedReports() {
        return amountsOwedReportRepository.findAll();
    }


//    @GetMapping("/work-limit-report/{userId}")
//    public ResponseEntity<WeeklyLimitReport> getWeeklyLimitReport(@PathVariable Integer userId) {
//        weeklyLimitTest.setUserId(userId);
//        weeklyLimitTest.execute();
//        System.out.println("###################################");
//        return ResponseEntity.ok().build();
//    }


}

