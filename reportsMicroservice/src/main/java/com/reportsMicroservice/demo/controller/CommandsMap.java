package com.reportsMicroservice.demo.controller;


import com.reportsMicroservice.demo.commands.*;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

@Component
public class CommandsMap {

    public static ConcurrentMap<String, Class<?>> cmdMap;

    @PostConstruct
    public static void instantiate() {
        cmdMap = new ConcurrentHashMap<>();
        cmdMap.put("AmountsOwedReportCommand", AmountsOwedReportCommand.class);
        cmdMap.put("ClientBudgetsReportCommand", ClientBudgetsReportCommand.class);
        cmdMap.put("PaymentsReportCommand", PaymentsReportCommand.class);
        cmdMap.put("ProjectBudgetsReportCommand", ProjectBudgetsReportCommand.class);
        cmdMap.put("TimeAndActivityReportCommand", TimeAndActivityReportCommand.class);
        cmdMap.put("WeeklyLimitReportCommand", WeeklyLimitReportCommand.class);
        cmdMap.put("WorkSessionReportCommand", WorkSessionReportCommand.class);
        cmdMap.put("WebServer_WorkSession", WebServer_WorkSession.class);

    }


    public static ConcurrentMap<String, Class<?>> delete(String cmd) {
        cmdMap.remove(cmd);
        Path path = Paths.get("reportsMicroservice/src/main/java/com/reportsMicroservice/demo/commands/" + cmd + ".java");
        try {
            boolean deleted = Files.deleteIfExists(path);
            if (deleted) {
                System.out.println("File deleted successfully.");
            } else {
                System.out.println("File not found, so it couldn't be deleted.");
            }
        } catch (IOException e) {
            System.err.println("An error occurred while trying to delete the file.");
            e.printStackTrace();
        }
        return cmdMap;
    }

    public static ConcurrentMap<String, Class<?>> add(String cmd) throws IOException {
        String ClassName = "com.reportsMicroservice.demo.commands." + cmd;
        byte[] bytes = Files.readAllBytes(Paths.get("reportsMicroservice/target/classes/com/reportsMicroservice/demo/commands/" + cmd + ".class"));
        MyClassLoader loader = new MyClassLoader();
        Class<?> newCommand = loader.loadClass(bytes, ClassName);
        cmdMap.put(cmd, newCommand);
        return cmdMap;
    }


    public static ConcurrentMap<String, Class<?>> returnMap() {
        return cmdMap;
    }


}
