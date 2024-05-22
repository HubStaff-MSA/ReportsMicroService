package com.reportsMicroservice.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class ToDoDTO {

    private Integer todoId;
    private String content;
    private Integer userId;  //Assignee

}
