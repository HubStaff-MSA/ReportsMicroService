package com.reportsMicroservice.demo.model;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "ToDo")
public class ToDo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "todo_id")
    private int todoId;

    @Column(name = "content", nullable = false)
    private String content;

    @ManyToOne
    @JoinColumn(name = "employee_id", referencedColumnName = "id")  // Changed from member_id to employee_id for clarity
    private Employee employee;  // Renamed field from member to employee

    @Column(name = "assignee_type", nullable = false)
    private String assigneeType;

    @Column(name = "created_at")
    private Date createdAt;

    @Column(name = "completed_at")
    private Date completedAt;

    // Getters and setters
    public int getTodoId() {
        return todoId;
    }

    public void setTodoId(int todoId) {
        this.todoId = todoId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Employee getAssignee() {
        return employee;
    }

    public void setAssignee(Employee assignee) {
        this.employee = assignee;
    }

    public String getAssigneeType() {
        return assigneeType;
    }

    public void setAssigneeType(String assigneeType) {
        this.assigneeType = assigneeType;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getCompletedAt() {
        return completedAt;
    }

    public void setCompletedAt(Date completedAt) {
        this.completedAt = completedAt;
    }
}