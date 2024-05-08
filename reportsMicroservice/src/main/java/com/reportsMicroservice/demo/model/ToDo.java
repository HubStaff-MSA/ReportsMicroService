package com.reportsMicroservice.demo.model;

import jakarta.persistence.*;
import lombok.Getter;

import java.util.Date;

@Getter
@Entity
@Table(name = "ToDo")
public class ToDo {
    // Getters and setters
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "todo_id")
    private Integer todoId;

    @Column(name = "content", nullable = false)
    private String content;

    @Column(name = "user_id", nullable = false)
    private Integer userId;  //Assignee


    public void setTodoId(int todoId) {
        this.todoId = todoId;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setEmployee(Integer employee) {
        this.userId = employee;
    }
}