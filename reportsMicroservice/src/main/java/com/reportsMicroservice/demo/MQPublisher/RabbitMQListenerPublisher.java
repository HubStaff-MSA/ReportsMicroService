package com.reportsMicroservice.demo.MQPublisher;

import com.reportsMicroservice.demo.dto.*;
import com.reportsMicroservice.demo.service.reports.ReportsService;
import org.apache.catalina.User;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RabbitMQListenerPublisher {

    private ProjectDTO Project;
    private UserDTO User;
    private ToDoDTO ToDo;
    private TrackTimeDTO trackTime;
    private PaymentDTO Payment;

    private ReportsService reportservice;

    @RabbitListener(queues = {"timetrack_reportsQueue", "todo_reportsQueue", "project_reportsQueue", "user_reportsQueue", "client_reportsQueue"})
    public void workSessionReport(List<TrackTimeDTO> trackTime , List<ToDoDTO> todo, List<ProjectDTO> project, UserDTO user , ClientDTO client) {
        System.out.println("Received TrackTime message:");
//        System.out.println("ID: " + trackTime.getId());
//        System.out.println("User ID: " + trackTime.getUserId());
//        System.out.println("Start Time: " + trackTime.getStartTime());
//        System.out.println("End Time: " + trackTime.getEndTime());
        reportservice.generateWorkSessionReports(user, project, client, todo, trackTime);
    }

    @RabbitListener(queues = {"timetrack_reportsQueue", "project_reportsQueue", "user_reportsQueue", "payment_reportQueue"})
    public void timeAndActivityReport(List<TrackTimeDTO> trackTime , List<PaymentDTO> payments, List<ProjectDTO> project, UserDTO user ) {
        System.out.println("Received TrackTime message:");
//        System.out.println("ID: " + trackTime.getId());
//        System.out.println("User ID: " + trackTime.getUserId());
//        System.out.println("Start Time: " + trackTime.getStartTime());
//        System.out.println("End Time: " + trackTime.getEndTime());
        reportservice.generateTimeAndActivityReports(user, project, trackTime, payments);
    }

    @RabbitListener(queues =  "user_reportsQueue")
    public void weeklyLimitReport( UserDTO user ) {
        System.out.println("Received TrackTime message:");
//        System.out.println("ID: " + trackTime.getId());
//        System.out.println("User ID: " + trackTime.getUserId());
//        System.out.println("Start Time: " + trackTime.getStartTime());
//        System.out.println("End Time: " + trackTime.getEndTime());
        reportservice.generateWeeklyLimitReport(user);
    }

    @RabbitListener(queues = { "project_reportsQueue", "payment_reportQueue"})
    public void projectBudgetReport( ProjectDTO project, List<PaymentDTO> payments) {
        System.out.println("Received TrackTime message:");
//        System.out.println("ID: " + trackTime.getId());
//        System.out.println("User ID: " + trackTime.getUserId());
//        System.out.println("Start Time: " + trackTime.getStartTime());
//        System.out.println("End Time: " + trackTime.getEndTime());
        reportservice.generateProjectBudgetsReport(project, payments);
    }

    @RabbitListener(queues = { "client_reportsQueue", "payment_reportsQueue"})
    public void clientBudgetReport( ClientDTO client, List<PaymentDTO> payments) {
        System.out.println("Received TrackTime message:");
//        System.out.println("ID: " + trackTime.getId());
//        System.out.println("User ID: " + trackTime.getUserId());
//        System.out.println("Start Time: " + trackTime.getStartTime());
//        System.out.println("End Time: " + trackTime.getEndTime());
        reportservice.generateClientBudgetsReport(client, payments);
    }

    @RabbitListener(queues = {"user_reportsQueue", "payment_reportsQueue"})
    public void paymentReport( UserDTO user , List<PaymentDTO> payments) {
        System.out.println("Received TrackTime message:");
//        System.out.println("ID: " + trackTime.getId());
//        System.out.println("User ID: " + trackTime.getUserId());
//        System.out.println("Start Time: " + trackTime.getStartTime());
//        System.out.println("End Time: " + trackTime.getEndTime());
        reportservice.generatePaymentsReport(user, payments);
    }


    @RabbitListener(queues = {"timetrack_reportsQueue", "user_reportsQueue"})
    public void amountOwedReport(List<TrackTimeDTO> trackTime ,   UserDTO user) {
        System.out.println("Received TrackTime message:");
//        System.out.println("ID: " + trackTime.getId());
//        System.out.println("User ID: " + trackTime.getUserId());
//        System.out.println("Start Time: " + trackTime.getStartTime());
//        System.out.println("End Time: " + trackTime.getEndTime());
        reportservice.generateAmountsOwedReport(user, trackTime);
    }




}