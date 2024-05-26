package com.reportsMicroservice.demo;


import com.reportsMicroservice.demo.dto.CommandSender;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.amqp.support.converter.DefaultJackson2JavaTypeMapper;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class RabbitMQConfig {

    @Bean
    public CachingConnectionFactory cachingConnectionFactory() {
        CachingConnectionFactory connectionFactory = new CachingConnectionFactory("rabbitmq");
        connectionFactory.setUsername("guest");
        connectionFactory.setPassword("guest");
        return connectionFactory;
    }

    @Bean
    public RabbitAdmin rabbitAdmin(CachingConnectionFactory cachingConnectionFactory) {
        return new RabbitAdmin(cachingConnectionFactory);
    }

    @Bean
    public Queue command2Queue() {
        return new Queue("commandQueue", false);
    }//I get the requests/commands from here... any service will send its command and payload here

    @Bean
    public Queue commandQueueProjects() {return new Queue("commandQueueProjects", false);}
    @Bean
    public Queue commandQueueTrackTime() {
        return new Queue("commandQueueTimeTracking", false);
    }
    @Bean
    public Queue commandQueueUser() {return new Queue("commandQueueUser", false);}
    @Bean
    public Queue commandQueueFinance() {return new Queue("commandQueueFinance", false);}

    @Bean
    public Queue timetrack_reportsQueue() {
        return new Queue("TT_R_Queue", false);
    }
    @Bean
    public Queue user_reportsQueue() {
        return new Queue("U_R_Queue", false);
    }
    @Bean
    public Queue finance_reportsQueue() {
        return new Queue("F_R_Queue", false);
    }
    @Bean
    public Queue reportsProjectsQueue()  {return new Queue("P_R_Projects_Queue", false);}
    @Bean
    public Queue reportsClientsQueue()  {return new Queue("P_R_Clients_Queue", false);}
    @Bean
    public Queue reportsToDosQueue()  {return new Queue("P_R_ToDos_Queue", false);}


    @Bean
    public Jackson2JsonMessageConverter messageConverter() {
        Jackson2JsonMessageConverter converter = new Jackson2JsonMessageConverter();
        DefaultJackson2JavaTypeMapper typeMapper = new DefaultJackson2JavaTypeMapper();
        Map<String, Class<?>> idClassMapping = new HashMap<>();
        idClassMapping.put("commandSender", CommandSender.class);
        typeMapper.setIdClassMapping(idClassMapping);
        converter.setJavaTypeMapper(typeMapper);
        return converter;
    }
}