package com.reportsMicroservice.demo.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/reports")
public class ReportsController {
    @GetMapping("/test")
    public ResponseEntity<String> testApi() {
        return ResponseEntity.ok("API is working");
    }

//    @GetMapping("/work-session")
//    public ResponseEntity<List<WorkSessionReport>> generateWorkSessionReports() {
//        List<WorkSessionReport> reportList = reportsService.generateWorkSessionReports(null, null, null, null, null);
//        if (reportList.isEmpty()) {
//            return ResponseEntity.notFound().build();
//        }
//        return ResponseEntity.ok(reportList);
//    }
//    @Autowired
//    private WorkSessionReportService workSessionReportService;
//
//    @Autowired
//    private TimeOffTransactionReportService timeoffTransactionReportService;
//
//    @Autowired
//    private TimeOffBalancesReportService timeoffBalancesReportService;
//
//    @Autowired
//    private ShiftAttendanceReportService shiftAttendanceReportService;
//
//    @Autowired
//    private AmountsOwedReportService amountsOwedReportService;
//
//    @Autowired
//    private ClientBudgetsReportService clientBudgetsReportService;
//
//    @Autowired
//    private ProjectBudgetsReportService projectBudgetsReportService;
//
//    @Autowired
//    private PaymentsReportService paymentsReportService;
//
//    @Autowired
//    private WeeklyLimitReportService WeeklyLimitReportService;
//
//
//    @Autowired
//    private TimeAndActivityReportService timeAndActivityReportService;
//
//    @GetMapping("/worksession/{userID}")
//    public ResponseEntity<List<WorkSessionReport>> getAllWorkSessionReports(@PathVariable("userID") Integer userID) {
//        List<WorkSessionReport> reportList = workSessionReportService.generateWorkSessionReports(userID);
//        if (reportList.isEmpty()) {
//            return ResponseEntity.notFound().build();
//        }
//        return ResponseEntity.ok(reportList);
//    }
//
//    @GetMapping("/timeofftransaction/{userID}")
//    public ResponseEntity<List<TimeOffTransactionReport>> getAllTimeOffTransactionReports(@PathVariable("userID") Integer userID){
//        List<TimeOffTransactionReport> reportList = timeoffTransactionReportService.generateTimeOffTransactionReports(userID);
//        if (reportList.isEmpty()) {
//            return ResponseEntity.notFound().build();
//        }
//        return ResponseEntity.ok(reportList);
//    }
//
//    @GetMapping("/timeoffbalances/{userID}")
//    public ResponseEntity<List<TimeOffBalancesReport>> getAllTimeOffBalancesReports(@PathVariable("userID") Integer userID){
//        List<TimeOffBalancesReport> reportList = timeoffBalancesReportService.generateTimeOffTransactionReports(userID);
//        if (reportList.isEmpty()) {
//            return ResponseEntity.notFound().build();
//        }
//        return ResponseEntity.ok(reportList);
//    }
//
//    @GetMapping("/amounts-owed/{userID}")
//    public ResponseEntity<List<AmountsOwedReport>> getAmountsOwedReport(@PathVariable("userID") Integer userID) {
//        try {
//            List<AmountsOwedReport> report = amountsOwedReportService.generateAmountsOwedReport(userID);
//            if (report.isEmpty()) {
//                return ResponseEntity.notFound().build();
//            }
//            return ResponseEntity.ok(report);
//        } catch (Exception e) {
//            return ResponseEntity.internalServerError().build();
//        }
//    }
//
//    @GetMapping("/client-budgets/{clientID}")
//    public ResponseEntity<List<ClientBudgetsReport>> getClientBudgetsReport(@PathVariable("clientID") Integer clientID) {
//        try {
//            List<ClientBudgetsReport> report = clientBudgetsReportService.generateClientBudgetsReport(clientID);
//            if (report.isEmpty()) {
//                return ResponseEntity.notFound().build();  // No report found for the client
//            }
//            return ResponseEntity.ok(report);
//        } catch (Exception e) {
//            return ResponseEntity.internalServerError().build();
//        }
//    }
//
//    @GetMapping("/project-budgets/{projectID}")
//    public ResponseEntity<List<ProjectBudgetsReport>> getProjectBudgetsReport(@PathVariable("projectID") Integer projectID) {
//        try {
//            List<ProjectBudgetsReport> report = projectBudgetsReportService.generateProjectBudgetsReport(projectID);
//            if (report.isEmpty()) {
//                return ResponseEntity.notFound().build();  // No report found for the project
//            }
//            return ResponseEntity.ok(report);
//        } catch (Exception e) {
//            return ResponseEntity.internalServerError().build();
//        }
//    }
//
//    @GetMapping("/payments/{userID}")
//    public ResponseEntity<List<PaymentsReport>> getPaymentsReport(@PathVariable("userID") Integer userID) {
//        try {
//            List<PaymentsReport> report = paymentsReportService.generatePaymentsReport(userID);
//            if (report.isEmpty()) {
//                return ResponseEntity.notFound().build();  // No report found for the user
//            }
//            return ResponseEntity.ok(report);
//        } catch (Exception e) {
//            return ResponseEntity.internalServerError().build();
//        }
//    }
//
//    @GetMapping("/weekly-limit/{userID}")
//    public ResponseEntity<List<WeeklyLimitReport>> getWeeklyLimitReport(@PathVariable Integer userID) {
//        List<WeeklyLimitReport> report = WeeklyLimitReportService.generateWeeklyLimitReport(userID);
//        if (report.isEmpty()) {
//            return ResponseEntity.notFound().build();
//        }
//        return ResponseEntity.ok(report);
//    }
//
//    @GetMapping("/shiftattendance/{userID}")
//    public ResponseEntity<List<ShiftAttendanceReport>> getAllShiftAttendanceReports(@PathVariable("userID") Integer userID ){
//        List<ShiftAttendanceReport> reportList = shiftAttendanceReportService.generateShiftAttendanceReports(userID);
//        if (reportList.isEmpty()) {
//            return ResponseEntity.notFound().build();
//        }
//        return ResponseEntity.ok(reportList);
//    }
//
//    @GetMapping("/timeandactivity/{userID}")
//    public ResponseEntity<List<TimeAndActivityReport>> getAllTimeAndActivityReports(
//            @PathVariable("userID") Integer userID
//    ) {
//        List<TimeAndActivityReport> reportList = timeAndActivityReportService.generateTimeAndActivityReports(userID);
//        if (reportList.isEmpty()) {
//            return ResponseEntity.notFound().build();
//        }
//        return ResponseEntity.ok(reportList);
//    }


}

