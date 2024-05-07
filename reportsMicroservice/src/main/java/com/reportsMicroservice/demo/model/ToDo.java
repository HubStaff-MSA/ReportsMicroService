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
    private int todoId;

    @Column(name = "content", nullable = false)
    private String content;

    @ManyToOne
    @JoinColumn(name = "employee_id", referencedColumnName = "id",nullable = false)
    private User employee;  //Assignee


    public void setTodoId(int todoId) {
        this.todoId = todoId;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setEmployee(User employee) {
        this.employee = employee;
    }
}