package com.reportsMicroservice.demo.MQPublisher;

import com.reportsMicroservice.demo.dto.*;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class RabbitMQListenerPublisher {

    private ProjectDTO Project;
    private UserDTO User;
    private ToDoDTO ToDo;
    private TrackTimeDTO trackTime;
    private PaymentDTO Payment;

    @RabbitListener(queues = "timetrack_reportsQueue")
    public void receiveMessage(TrackTimeDTO trackTime) {
        System.out.println("Received TrackTime message:");
        System.out.println("ID: " + trackTime.getId());
        System.out.println("User ID: " + trackTime.getUserId());
        System.out.println("Start Time: " + trackTime.getStartTime());
        System.out.println("End Time: " + trackTime.getEndTime());
    }

    @RabbitListener(queues = "project_reportsQueue")
    public void receiveMessage(ProjectDTO project) {
        System.out.println("Received Project message:");
        System.out.println("ID: " + project.getProjectId());
        System.out.println("Name: " + project.getProjectId());
    }

    @RabbitListener(queues = "todo_reportsQueue")
    public void receiveMessage(ToDoDTO toDo) {
        System.out.println("Received ToDo message:");
        System.out.println("Name: " + toDo.getTitle());
        System.out.println("Description: " + toDo.getDescription());
    }

    @RabbitListener(queues = "client_reportsQueue")
    public void receiveMessage(ClientDTO client) {
        System.out.println("Received Client message:");
        System.out.println("ID: " + client.getClientId());
        System.out.println("Name: " + client.getClientName());
    }

    @RabbitListener(queues = "payment_reportsQueue")
    public void receiveMessage(PaymentDTO payment) {
        System.out.println("Received Payment message:");
        System.out.println("ID: " + payment.getPaymentID());
        System.out.println("Amount: " + payment.getAmount());
        System.out.println("User ID: " + payment.getMemberId());
        System.out.println("Project ID: " + payment.getProjectId());
        System.out.println("Payer ID: " + payment.getPayerId());
    }

    @RabbitListener(queues = "user_reportsQueue")
    public void receiveMessage(UserDTO user) {
        System.out.println("Received User message:");
        System.out.println("ID: " + user.getId());
        System.out.println("Name: " + user.getFullName());
        System.out.println("Email: " + user.getWorkEmail());
    }




}