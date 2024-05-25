package com.reportsMicroservice.demo.MQPublisher;

import com.reportsMicroservice.demo.dto.*;
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

//    @RabbitListener(queues = {"timetrack_reportsQueue", "todo_reportsQueue", "project_reportsQueue", "user_reportsQueue", "client_reportsQueue"})
//    public void workSessionReport(List<TrackTimeDTO> trackTime , List<ToDoDTO> todo, List<ProjectDTO> project, UserDTO user , ClientDTO client) {
//        System.out.println("Received TrackTime message:");
////        System.out.println("ID: " + trackTime.getId());
////        System.out.println("User ID: " + trackTime.getUserId());
////        System.out.println("Start Time: " + trackTime.getStartTime());
////        System.out.println("End Time: " + trackTime.getEndTime());
//        reportservice.generateWorkSessionReports(user, project, client, todo, trackTime);
//    }
//
//    @RabbitListener(queues = {"timetrack_reportsQueue", "project_reportsQueue", "user_reportsQueue", "payment_reportsQueue"})
//    public void timeAndActivityReport(List<TrackTimeDTO> trackTime , List<PaymentDTO> payments, List<ProjectDTO> project, UserDTO user ) {
//        System.out.println("Received TrackTime message:");
////        System.out.println("ID: " + trackTime.getId());
////        System.out.println("User ID: " + trackTime.getUserId());
////        System.out.println("Start Time: " + trackTime.getStartTime());
////        System.out.println("End Time: " + trackTime.getEndTime());
//        reportservice.generateTimeAndActivityReports(user, project, trackTime, payments);
//    }
//
//    @RabbitListener(queues =  "user_reportsQueue")
//    public void weeklyLimitReport( UserDTO user ) {
//        System.out.println("Received TrackTime message:");
////        System.out.println("ID: " + trackTime.getId());
////        System.out.println("User ID: " + trackTime.getUserId());
////        System.out.println("Start Time: " + trackTime.getStartTime());
////        System.out.println("End Time: " + trackTime.getEndTime());
//        reportservice.generateWeeklyLimitReport(user);
//    }
//
//    @RabbitListener(queues = { "project_reportsQueue", "payment_reportsQueue"})
//    public void projectBudgetReport( ProjectDTO project, List<PaymentDTO> payments) {
//        System.out.println("Received TrackTime message:");
////        System.out.println("ID: " + trackTime.getId());
////        System.out.println("User ID: " + trackTime.getUserId());
////        System.out.println("Start Time: " + trackTime.getStartTime());
////        System.out.println("End Time: " + trackTime.getEndTime());
//        reportservice.generateProjectBudgetsReport(project, payments);
//    }
//
//    @RabbitListener(queues = { "client_reportsQueue", "payment_reportsQueue"})
//    public void clientBudgetReport( ClientDTO client, List<PaymentDTO> payments) {
//        System.out.println("Received TrackTime message:");
////        System.out.println("ID: " + trackTime.getId());
////        System.out.println("User ID: " + trackTime.getUserId());
////        System.out.println("Start Time: " + trackTime.getStartTime());
////        System.out.println("End Time: " + trackTime.getEndTime());
//        reportservice.generateClientBudgetsReport(client, payments);
//    }
//
//    @RabbitListener(queues = {"user_reportsQueue", "payment_reportsQueue"})
//    public void paymentReport( UserDTO user , List<PaymentDTO> payments) {
//        System.out.println("Received TrackTime message:");
////        System.out.println("ID: " + trackTime.getId());
////        System.out.println("User ID: " + trackTime.getUserId());
////        System.out.println("Start Time: " + trackTime.getStartTime());
////        System.out.println("End Time: " + trackTime.getEndTime());
//        reportservice.generatePaymentsReport(user, payments);
//    }
//
//
//    @RabbitListener(queues = {"timetrack_reportsQueue", "user_reportsQueue"})
//    public void amountOwedReport(List<TrackTimeDTO> trackTime ,   UserDTO user) {
//        System.out.println("Received TrackTime message:");
////        System.out.println("ID: " + trackTime.getId());
////        System.out.println("User ID: " + trackTime.getUserId());
////        System.out.println("Start Time: " + trackTime.getStartTime());
////        System.out.println("End Time: " + trackTime.getEndTime());
//        reportservice.generateAmountsOwedReport(user, trackTime);
//    }


    @RabbitListener(queues = "T_R_Queue")
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
}
