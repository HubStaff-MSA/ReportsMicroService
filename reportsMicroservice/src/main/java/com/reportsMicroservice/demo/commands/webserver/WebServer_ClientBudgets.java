package com.reportsMicroservice.demo.commands.webserver;

import com.reportsMicroservice.demo.commands.Command;
import com.reportsMicroservice.demo.dto.CommandSender;
import com.reportsMicroservice.demo.dto.PMtoReportsClientDTO;
import com.reportsMicroservice.demo.dto.PaymentDTO;
import com.reportsMicroservice.demo.model.reports.ClientBudgetsReport;
import com.reportsMicroservice.demo.model.reports.TimeAndActivityReport;
import com.reportsMicroservice.demo.service.reports.ReportsService;
import org.springframework.amqp.rabbit.core.RabbitTemplate;

import java.util.List;

public class WebServer_ClientBudgets implements Command {
    private String clientId;
    private final RabbitTemplate rabbitTemplate;
    private final ReportsService reportsService;
    private List<ClientBudgetsReport> returnedValue;

    public WebServer_ClientBudgets(String id,
                              RabbitTemplate rabbitTemplate,
                              ReportsService reportsService) {
        this.clientId = id;
        this.rabbitTemplate = rabbitTemplate;
        this.reportsService = reportsService;
    }

    @Override
    public void execute() {
        CommandSender command = new CommandSender("getClientCommand", clientId,
                "P_R_Clients_Queue");
        PMtoReportsClientDTO client = (PMtoReportsClientDTO) rabbitTemplate.convertSendAndReceive("commandQueueProjects", command);

        //List of payments by client
        CommandSender command2 = new CommandSender("getTotalAmountByPayerId", clientId,
                "F_R_Queue");
        List<PaymentDTO> payments = (List<PaymentDTO>) rabbitTemplate.convertSendAndReceive("commandQueueFinance", command2);

        returnedValue = reportsService.generateClientBudgetsReport(client, payments);


    }


}
