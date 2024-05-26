package com.reportsMicroservice.demo.dto;

import lombok.*;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CommandSender implements Serializable {

    private String command;
    private Object payload;
    private String requestingQueue;

}
