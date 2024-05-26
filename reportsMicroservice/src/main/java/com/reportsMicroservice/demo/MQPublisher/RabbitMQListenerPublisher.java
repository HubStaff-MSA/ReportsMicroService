package com.reportsMicroservice.demo.MQPublisher;

import com.reportsMicroservice.demo.dto.*;
import com.reportsMicroservice.demo.model.reports.WeeklyLimitReport;
import com.reportsMicroservice.demo.service.reports.ReportsService;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RabbitMQListenerPublisher {

    private PMtoReportsProjectDTO Project;
    private UserDTO User;
    private PMtoReportsToDoDTO ToDo;
    private TT_dto trackTime;
    private PaymentDTO Payment;

    private ReportsService reportservice;

    public RabbitMQListenerPublisher(ReportsService reportservice) {
        this.reportservice = reportservice;
    }

    // User to Reports Queue
    @RabbitListener(queues = "U_R_Queue")
    public void testUser(UserDTO user) {
        System.out.println("Received TrackTime messages:");
        //List < WeeklyLimitReport> weeklyLimitReports = reportservice.generateWeeklyLimitReport(user);

    }

    // Time Tracking to Reports Queue
    @RabbitListener(queues = "TT_R_Queue")
    public void test(List<TT_dto> trackTimes) {
        System.out.println("Received TrackTime messages:");
        System.out.println(trackTimes);

        for (TT_dto trackTime : trackTimes) {
            System.out.println("ID: " + trackTime.getDuration());
            System.out.println("User ID: " + trackTime.getUserId());
            System.out.println("Start Time: " + trackTime.getStartTime());
            System.out.println("End Time: " + trackTime.getEndTime());
        }


    }

    // Payment to Reports Queue
    @RabbitListener(queues = "P_R_Queue")
    public void testProject(List<PMtoReportsProjectDTO> projects) {
        System.out.println("Received Project messages:");
        System.out.println(projects);

        for (PMtoReportsProjectDTO project : projects) {
            System.out.println("ID: " + project.getProjectId());
            System.out.println("Project Name: " + project.getProjectName());
            System.out.println("Client Id: " + project.getClientId());
            System.out.println("Budget Cost: " + project.getBudgetCost());

        }
    }

    // Finance to Reports Queue
    @RabbitListener(queues = "F_R_Queue")
    public void testPayment(List<PaymentDTO> payments) {
        System.out.println("Received Payment messages:");
        System.out.println(payments);

        for (PaymentDTO payment : payments) {
            System.out.println("ID: " + payment.getPaymentID());
            System.out.println("Project ID: " + payment.getProjectId());
            System.out.println("Amount: " + payment.getAmount());
            System.out.println("Payer: " + payment.getPayerId());
            System.out.println("Payee: " + payment.getMemberId());
        }
    }
}
