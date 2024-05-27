package com.reportsMicroservice.demo.commands.webserver;

import com.reportsMicroservice.demo.commands.Command;
import com.reportsMicroservice.demo.dto.*;
import com.reportsMicroservice.demo.model.reports.TimeAndActivityReport;
import com.reportsMicroservice.demo.model.reports.WorkSessionReport;
import com.reportsMicroservice.demo.service.reports.ReportsService;
import org.springframework.amqp.rabbit.core.RabbitTemplate;

import java.util.List;

public class WebServer_TimeAndActivity implements Command {

    private String id;
    private final RabbitTemplate rabbitTemplate;
    private final ReportsService reportsService;
    private List<TimeAndActivityReport> returnedValue;

    public WebServer_TimeAndActivity(String id,
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

        //List of time tracks
        CommandSender command2 = new CommandSender("ListOfTimeTracksByUsersIds", List.of(id),
                "TT_R_Queue");
       List<TT_dto> timetracks = (List<TT_dto>) rabbitTemplate.convertSendAndReceive("WebServerCommandQueueTimeTracking", command2);

        //List of projects
        CommandSender command3 = new CommandSender("getProjectsByUserIdCommand", id,
                "P_R_Projects_Queue");
        List<PMtoReportsProjectDTO> projects= (List<PMtoReportsProjectDTO>) rabbitTemplate.convertSendAndReceive("webServerCommandQueueProjects", command3);

        //List of payments
        CommandSender command4 = new CommandSender("getTotalAmountPerMember", id,
                "F_R_Queue");
       List<PaymentDTO> payments = (List<PaymentDTO>) rabbitTemplate.convertSendAndReceive("WebServerQueueFinance", command4);

        returnedValue = reportsService.generateTimeAndActivityReports(user, projects, timetracks, payments);


    }
}
