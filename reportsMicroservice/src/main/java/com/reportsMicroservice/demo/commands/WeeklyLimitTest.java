package com.reportsMicroservice.demo.commands;

import com.reportsMicroservice.demo.MQPublisher.RabbitMQServicePublisher;
import com.reportsMicroservice.demo.dto.CommandSender;
import com.reportsMicroservice.demo.dto.UserDTO;
import com.reportsMicroservice.demo.service.reports.ReportsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class WeeklyLimitTest implements Command {


    private Integer userId;
    private RabbitMQServicePublisher rabbitMQServicePublisher ;

    @Autowired
    public WeeklyLimitTest(RabbitMQServicePublisher rabbitMQServicePublisher) {
        this.rabbitMQServicePublisher = rabbitMQServicePublisher;
    }

        public void setUserId(Integer userId) {
            this.userId = userId;
        }

        @Override
        public void execute() {
            String command = "GetUser";
            Object payload = userId;
            String requestQueue = "U_R_Queue";
            CommandSender commandSender = new CommandSender(command, payload, requestQueue);
            rabbitMQServicePublisher.sendMessage("commandQueueUser",commandSender);
            System.out.println("----------------------------------------Message sent to User Microservice "+userId);

        }
    }

