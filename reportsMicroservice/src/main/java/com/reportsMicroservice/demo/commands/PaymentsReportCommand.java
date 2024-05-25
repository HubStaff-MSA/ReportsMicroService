package com.reportsMicroservice.demo.commands;

import com.reportsMicroservice.demo.dto.PaymentDTO;
import com.reportsMicroservice.demo.dto.UserDTO;
import com.reportsMicroservice.demo.service.reports.ReportsService;

import java.util.List;

public class PaymentsReportCommand implements Command {
    private ReportsService reportsService;
    private UserDTO user;
    private List<PaymentDTO> payments;

    public PaymentsReportCommand(ReportsService reportsService, UserDTO user, List<PaymentDTO> payments) {
        this.reportsService = reportsService;
        this.user = user;
        this.payments = payments;
    }

    @Override
    public void execute() {
        reportsService.generatePaymentsReport(user, payments);
    }

}
