package com.reportsMicroservice.demo.model.others;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class ToDo {

    private Integer todoId;
    private String content;
    private Integer userId;  //Assignee

}