package com.reportsMicroservice.demo.MQPublisher;

import com.reportsMicroservice.demo.commands.*;
import com.reportsMicroservice.demo.dto.*;
import com.reportsMicroservice.demo.model.reports.WeeklyLimitReport;
import com.reportsMicroservice.demo.service.reports.ReportsService;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RabbitMQListenerPublisher {
    private final ReportsService reportsService;
    private final CommandInvoker commandInvoker;
    private UserDTO user;
    private List<PMtoReportsProjectDTO> projects;
    private PMtoReportsClientDTO client;
    private List<PMtoReportsToDoDTO> todos;
    private List<TT_dto> trackTimes;
    private List<PaymentDTO> payments;


    public RabbitMQListenerPublisher(ReportsService reportsService, CommandInvoker commandInvoker) {
        this.reportsService = reportsService;
        this.commandInvoker = commandInvoker;
    }

    // User to Reports Queue
    @RabbitListener(queues = "U_R_Queue")
    public void receiveUserData(UserDTO user) {
        System.out.println("Received TrackTime messages:");
        this.user = user;
        processCommands();
    }

    // Time Tracking to Reports Queue
    @RabbitListener(queues = "TT_R_Queue")
    public void receiveTrackTimes(List<TT_dto> trackTimes) {
        this.trackTimes = trackTimes;
        processCommands();

        for (TT_dto trackTime : trackTimes) {
            System.out.println("ID: " + trackTime.getDuration());
            System.out.println("User ID: " + trackTime.getUserId());
            System.out.println("Start Time: " + trackTime.getStartTime());
            System.out.println("End Time: " + trackTime.getEndTime());
        }


    }

    // Payment to Reports Queue
    @RabbitListener(queues = "P_R_Queue")
    public void receiveProjects(List<PMtoReportsProjectDTO> projects) {
        this.projects = projects;
        processCommands();

        for (PMtoReportsProjectDTO project : projects) {
            System.out.println("ID: " + project.getProjectId());
            System.out.println("Project Name: " + project.getProjectName());
            System.out.println("Client Id: " + project.getClientId());
            System.out.println("Budget Cost: " + project.getBudgetCost());

        }
    }

    // Finance to Reports Queue
    @RabbitListener(queues = "F_R_Queue")
    public void receivePayments(List<PaymentDTO> payments) {
        this.payments = payments;
        processCommands();

        for (PaymentDTO payment : payments) {
            System.out.println("ID: " + payment.getPaymentID());
            System.out.println("Project ID: " + payment.getProjectId());
            System.out.println("Amount: " + payment.getAmount());
            System.out.println("Payer: " + payment.getPayerId());
            System.out.println("Payee: " + payment.getMemberId());
        }
    }

    private void processCommands() {

        //work session report
        if (user != null && projects != null && trackTimes != null && client != null && todos != null) {
            Command workSessionCommand = new WorkSessionReportCommand(reportsService, user, projects, client, todos, trackTimes);
            commandInvoker.executeCommand(workSessionCommand);
            resetData();
        }
        //time and activity report
        if (user != null && projects != null && trackTimes != null && payments != null) {
            Command timeAndActivityCommand = new TimeAndActivityReportCommand(reportsService, user, projects, trackTimes, payments);
            commandInvoker.executeCommand(timeAndActivityCommand);
            resetData();
        }
        //weekly limit report
        if (user!=null){
            Command weeklyLimitCommand = new WeeklyLimitReportCommand(reportsService, user);
            commandInvoker.executeCommand(weeklyLimitCommand);
            resetData();
        }
        //project budget report (projects and payments)
        if (projects != null && payments != null) {
            Command projectBudgetCommand = new ProjectBudgetsReportCommand(reportsService, projects.get(0), payments);
            commandInvoker.executeCommand(projectBudgetCommand);
            resetData();
        }
        //client budget report (client and payments)
        if (client != null && payments != null) {
            Command clientBudgetCommand = new ClientBudgetsReportCommand(reportsService, client, payments);
            commandInvoker.executeCommand(clientBudgetCommand);
            resetData();
        }
        //payments report (user and payments)
        if (user != null && payments != null) {
            Command paymentsCommand = new PaymentsReportCommand(reportsService, user, payments);
            commandInvoker.executeCommand(paymentsCommand);
            resetData();
        }
        //amounts owed report (user and timetracks)
        if (user != null && trackTimes != null) {
            Command amountCommand = new AmountsOwedReportCommand(reportsService, user, trackTimes);
            commandInvoker.executeCommand(amountCommand);
            resetData();
        }

    }
    private void resetData() {
        user = null;
        projects = null;
        client = null;
        todos = null;
        trackTimes = null;
        payments = null;
    }
}
