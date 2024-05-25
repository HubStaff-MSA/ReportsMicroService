package com.reportsMicroservice.demo.commands;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CommandInvokerConfig {
    @Bean
    public CommandInvoker commandInvoker() {
        return new CommandInvoker();
    }
}
