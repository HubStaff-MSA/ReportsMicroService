package com.reportsMicroservice.demo.commands.webserver;

import com.reportsMicroservice.demo.commands.Command;
import com.reportsMicroservice.demo.dto.CommandSender;
import com.reportsMicroservice.demo.dto.PaymentDTO;
import com.reportsMicroservice.demo.dto.UserDTO;
import com.reportsMicroservice.demo.model.reports.PaymentsReport;
import com.reportsMicroservice.demo.model.reports.TimeAndActivityReport;
import com.reportsMicroservice.demo.service.reports.ReportsService;
import org.springframework.amqp.rabbit.core.RabbitTemplate;

import java.util.List;

public class WebServer_Payments implements Command {
    private String id;
    private final RabbitTemplate rabbitTemplate;
    private final ReportsService reportsService;
    private List<PaymentsReport> returnedValue;

    public WebServer_Payments(String id,
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

        //List of payments
        CommandSender command2 = new CommandSender("getTotalAmountPerMember", id,
                "F_R_Queue");
        List<PaymentDTO> payments = (List<PaymentDTO>) rabbitTemplate.convertSendAndReceive("commandQueueFinance", command2);

        returnedValue = reportsService.generatePaymentsReport(user, payments);

    }

}
