package com.reportsMicroservice.demo.model.others;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
public class ToDo {

    private Integer todoId;
    private String content;
    private Integer userId;  //Assignee

}