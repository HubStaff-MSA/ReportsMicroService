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

//    @RabbitListener(queues = "tracktime_reportsQueue")
//    public void receiveMessage(TrackTime trackTime) {
//        System.out.println("Received TrackTime message:");
//        System.out.println("ID: " + trackTime.getId());
//        System.out.println("User ID: " + trackTime.getUserId());
//        System.out.println("Start Time: " + trackTime.getStartTime());
//        System.out.println("End Time: " + trackTime.getEndTime());
//            generateReport(trackTime);
//            generateReport(trackTime, Project);
//    }


}