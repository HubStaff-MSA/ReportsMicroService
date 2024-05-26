package com.reportsMicroservice.demo.commands.webserver;

import com.reportsMicroservice.demo.commands.Command;
import com.reportsMicroservice.demo.dto.CommandSender;
import com.reportsMicroservice.demo.dto.TT_dto;
import com.reportsMicroservice.demo.dto.UserDTO;
import com.reportsMicroservice.demo.model.reports.AmountsOwedReport;
import com.reportsMicroservice.demo.model.reports.PaymentsReport;
import com.reportsMicroservice.demo.model.reports.TimeAndActivityReport;
import com.reportsMicroservice.demo.service.reports.ReportsService;
import org.springframework.amqp.rabbit.core.RabbitTemplate;

import java.util.List;

public class WebServer_AmountsOwed implements Command {
    private String id;
    private final RabbitTemplate rabbitTemplate;
    private final ReportsService reportsService;
    private List<AmountsOwedReport> returnedValue;

    public WebServer_AmountsOwed(String id,
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
        UserDTO user = (UserDTO) rabbitTemplate.convertSendAndReceive("commandQueueUser", command);

        //List of timetracks
        CommandSender command2 = new CommandSender("ListOfTimeTracksByUsersIds", id,
                "TT_R_Queue");
        List<TT_dto> timetracks = (List<TT_dto>) rabbitTemplate.convertSendAndReceive("commandQueueTimeTracking", command2);

        returnedValue = reportsService.generateAmountsOwedReport(user, timetracks);

    }
}
