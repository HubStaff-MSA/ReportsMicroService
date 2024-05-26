package com.reportsMicroservice.demo.MQPublisher;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.reportsMicroservice.demo.commands.*;
import com.reportsMicroservice.demo.controller.CommandsMap;
import com.reportsMicroservice.demo.dto.*;
import com.reportsMicroservice.demo.model.reports.WeeklyLimitReport;
import com.reportsMicroservice.demo.service.reports.ReportsService;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.concurrent.ConcurrentHashMap;

import java.lang.reflect.Field;
import java.util.List;

@Service
public class RabbitMQListenerPublisher {
    private final ReportsService reportsService;
    private final CommandInvoker commandInvoker;
    private UserDTO user;
    private List<PMtoReportsProjectDTO> projects;
    private PMtoReportsClientDTO client;
    private List<PMtoReportsToDoDTO> todos;
    private List<TT_dto> trackTimes;
    private List<PaymentDTO> payments;
    private final RabbitTemplate rabbitTemplate;


    public RabbitMQListenerPublisher(ReportsService reportsService, CommandInvoker commandInvoker, RabbitTemplate rabbitTemplate) {
        this.reportsService = reportsService;
        this.commandInvoker = commandInvoker;
        this.rabbitTemplate = rabbitTemplate;
    }

    @RabbitListener(queues = "commandQueueReports")
    public Object receiveMessage(CommandSender commandSender) throws NoSuchFieldException, IllegalAccessException, NoSuchMethodException, InvocationTargetException, InstantiationException, JsonProcessingException {
        Object returnedValue = callCmdMap(commandSender.getCommand() , commandSender.getPayload());

        //System.out.println(returnedValue.toString());
        return returnedValue;
    }

    public Object callCmdMap(String Command , Object Payload) throws InvocationTargetException, IllegalAccessException, NoSuchMethodException, InstantiationException, NoSuchFieldException {
        Field cmdMapField = CommandsMap.class.getDeclaredField("cmdMap");

        // Make the field accessible
        cmdMapField.setAccessible(true);
        // Get the cmdMap value
        Object cmdMapValue = cmdMapField.get(null);
        // Assuming cmdMapValue is a Map<String, Class<?>>
        ConcurrentHashMap<String, Class<?>> cmdMap = (ConcurrentHashMap<String, Class<?>>) cmdMapValue;

        Class<?> commandClass = (Class<?>) cmdMap.get(Command);

        // Object commandInstance = commandClass.newInstance();
        Object commandInstance = commandClass.getDeclaredConstructor(ReportsService.class).newInstance(reportsService);

        // Get the build method of the command class
        Method buildMethod = commandClass.getDeclaredMethod("build", Object.class);

        // Invoke the build method
        buildMethod.invoke(commandInstance, Payload);

        // Get the execute method of the command class
        Method executeMethod = commandClass.getDeclaredMethod("execute", null);

        // Invoke the execute method
        executeMethod.invoke(commandInstance);

        // Get the returned field of the command class
        Field returnedField = commandClass.getDeclaredField("returned");

        // Make the field accessible
        returnedField.setAccessible(true);

        // Get the value of the returned field from the command instance
        Object returnedValue = (Object) returnedField.get(commandInstance);

        return returnedValue;
    }

    // User to Reports Queue
    @RabbitListener(queues = "U_R_Queue")
    public void receiveUserData(UserDTO user) {
        System.out.println("Received TrackTime messages:");
        this.user = user;
        processCommands();
    }

    // Time Tracking to Reports Queue
    @RabbitListener(queues = "TT_R_Queue")
    public void receiveTrackTimes(List<TT_dto> trackTimes) {
        this.trackTimes = trackTimes;
        processCommands();

        for (TT_dto trackTime : trackTimes) {
            System.out.println("ID: " + trackTime.getDuration());
            System.out.println("User ID: " + trackTime.getUserId());
            System.out.println("Start Time: " + trackTime.getStartTime());
            System.out.println("End Time: " + trackTime.getEndTime());
        }


    }

    // Payment to Reports Queue
    @RabbitListener(queues = "P_R_Projects_Queue")
    public void receiveProjects(List<PMtoReportsProjectDTO> projects) {
        this.projects = projects;
        processCommands();

        for (PMtoReportsProjectDTO project : projects) {
            System.out.println("ID: " + project.getProjectId());
            System.out.println("Project Name: " + project.getProjectName());
            System.out.println("Client Id: " + project.getClientId());
            System.out.println("Budget Cost: " + project.getBudgetCost());

        }
    }

    // Client to Reports Queue
    @RabbitListener(queues = "P_R_Clients_Queue")
    public void receiveClient(PMtoReportsClientDTO client) {
        this.client = client;
        processCommands();

        System.out.println("ID: " + client.getClientId());
        System.out.println("Client Name: " + client.getClientName());
        System.out.println("Budget Cost: " + client.getBudgetCost());
    }

    // ToDos to Reports Queue
    @RabbitListener(queues = "P_R_ToDos_Queue")
    public void receiveToDos(List<PMtoReportsToDoDTO> todos) {
        this.todos = todos;
        processCommands();

        for (PMtoReportsToDoDTO todo : todos) {
            System.out.println("Title: " + todo.getTitle());
            System.out.println("Description: " + todo.getDescription());
            System.out.println("USER ID: " + todo.getUserId());
        }
    }

    // Finance to Reports Queue
    @RabbitListener(queues = "F_R_Queue")
    public void receivePayments(List<PaymentDTO> payments) {
        this.payments = payments;
        processCommands();

        for (PaymentDTO payment : payments) {
            System.out.println("ID: " + payment.getPaymentID());
            System.out.println("Project ID: " + payment.getProjectId());
            System.out.println("Amount: " + payment.getAmount());
            System.out.println("Payer: " + payment.getPayerId());
            System.out.println("Payee: " + payment.getMemberId());
        }
    }

    public void processCommands() {

        //work session report
        if (user != null && projects != null && trackTimes != null && client != null && todos != null) {
            Command workSessionCommand = new WorkSessionReportCommand(reportsService, user, projects, todos, trackTimes);
            commandInvoker.executeCommand(workSessionCommand);
            resetData();
        }
        //time and activity report
        if (user != null && projects != null && trackTimes != null && payments != null) {
            Command timeAndActivityCommand = new TimeAndActivityReportCommand(reportsService, user, projects, trackTimes, payments);
            commandInvoker.executeCommand(timeAndActivityCommand);
            resetData();
        }
        //weekly limit report
        if (user!=null){
            Command weeklyLimitCommand = new WeeklyLimitReportCommand(reportsService, user);
            commandInvoker.executeCommand(weeklyLimitCommand);
            resetData();
        }
        //project budget report (projects and payments)
        if (projects != null && payments != null) {
            Command projectBudgetCommand = new ProjectBudgetsReportCommand(reportsService, projects.get(0), payments);
            commandInvoker.executeCommand(projectBudgetCommand);
            resetData();
        }
        //client budget report (client and payments)
        if (client != null && payments != null) {
            Command clientBudgetCommand = new ClientBudgetsReportCommand(reportsService, client, payments);
            commandInvoker.executeCommand(clientBudgetCommand);
            resetData();
        }
        //payments report (user and payments)
        if (user != null && payments != null) {
            Command paymentsCommand = new PaymentsReportCommand(reportsService, user, payments);
            commandInvoker.executeCommand(paymentsCommand);
            resetData();
        }
        //amounts owed report (user and timetracks)
        if (user != null && trackTimes != null) {
            Command amountCommand = new AmountsOwedReportCommand(reportsService, user, trackTimes);
            commandInvoker.executeCommand(amountCommand);
            resetData();
        }

    }
    private void resetData() {
        user = null;
        projects = null;
        client = null;
        todos = null;
        trackTimes = null;
        payments = null;
    }
}
