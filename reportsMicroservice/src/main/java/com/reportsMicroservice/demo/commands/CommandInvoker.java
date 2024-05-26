package com.reportsMicroservice.demo.commands;

import java.util.ArrayList;
import java.util.List;

public class CommandInvoker {
    public void executeCommand(Command command) {
        command.execute();
    }
}