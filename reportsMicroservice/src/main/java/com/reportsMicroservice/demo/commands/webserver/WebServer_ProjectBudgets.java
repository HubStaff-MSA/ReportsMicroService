package com.reportsMicroservice.demo.commands.webserver;

import com.reportsMicroservice.demo.commands.Command;
import com.reportsMicroservice.demo.dto.CommandSender;
import com.reportsMicroservice.demo.dto.PMtoReportsProjectDTO;
import com.reportsMicroservice.demo.dto.PaymentDTO;
import com.reportsMicroservice.demo.dto.UserDTO;
import com.reportsMicroservice.demo.model.reports.ProjectBudgetsReport;
import com.reportsMicroservice.demo.model.reports.TimeAndActivityReport;
import com.reportsMicroservice.demo.service.reports.ReportsService;
import org.springframework.amqp.rabbit.core.RabbitTemplate;

import java.util.List;

public class WebServer_ProjectBudgets implements Command {
    private String projectId;
    private final RabbitTemplate rabbitTemplate;
    private final ReportsService reportsService;
    private List<ProjectBudgetsReport> returnedValue;

    public WebServer_ProjectBudgets(String id,
                                     RabbitTemplate rabbitTemplate,
                                     ReportsService reportsService) {
        this.projectId = id;
        this.rabbitTemplate = rabbitTemplate;
        this.reportsService = reportsService;
    }

    @Override
    public void execute() {
        CommandSender command = new CommandSender("getProject", projectId,
                "P_R_Projects_Queue");
        PMtoReportsProjectDTO project = (PMtoReportsProjectDTO) rabbitTemplate.convertSendAndReceive("commandQueueProjects", command);

        //List of payments by project
        CommandSender command2 = new CommandSender("getTotalAmountPerProject", projectId,
                "F_R_Queue");
        List<PaymentDTO> payments = (List<PaymentDTO>) rabbitTemplate.convertSendAndReceive("commandQueueFinance", command2);
        returnedValue = reportsService.generateProjectBudgetsReport(project, payments);

    }


}
