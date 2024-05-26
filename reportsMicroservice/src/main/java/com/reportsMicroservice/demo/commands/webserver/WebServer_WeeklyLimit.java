package com.reportsMicroservice.demo.commands.webserver;

import com.reportsMicroservice.demo.commands.Command;
import com.reportsMicroservice.demo.dto.CommandSender;
import com.reportsMicroservice.demo.dto.UserDTO;
import com.reportsMicroservice.demo.model.reports.WeeklyLimitReport;
import com.reportsMicroservice.demo.model.reports.WorkSessionReport;
import com.reportsMicroservice.demo.service.reports.ReportsService;
import org.apache.catalina.User;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import java.util.List;

public class WebServer_WeeklyLimit implements Command {
    private String id;
    private final RabbitTemplate rabbitTemplate;
    private final ReportsService reportsService;
    private List<WeeklyLimitReport> returnedValue;

    public WebServer_WeeklyLimit(String id,
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
        UserDTO user = (UserDTO) rabbitTemplate.convertSendAndReceive("WebServerUserQueue", command);
        returnedValue = reportsService.generateWeeklyLimitReport(user);
    }

}
