package com.reportsMicroservice.demo.model;

import jakarta.persistence.*;
import lombok.Getter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Getter
@Entity
@Table(name = "timesheet_time")
public class Timesheet_time {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "timesheet_id")
    private Integer timesheetId;

    @Getter
    @Column(name = "user_id")
    private Integer userId;

    @Getter
    @Column(name = "project_id")
    private Integer projectId;

    @Getter
    @Column(name = "todo_id")
    private Integer todoId;

    @Column(name = "date")
    private LocalDate date;

    @Column(name = "start_time")
    private LocalTime startTime;

    @Column(name = "end_time")
    private LocalTime endTime;

    @Column(name = "billable")
    private boolean billable;

    @Column(name = "reason")
    private String reason;

    @Column(name = "note")
    private String note;

    @Column(name = "duration")
    private LocalTime duration;

    @Column(name = "manual")
    private boolean manual;

    @Enumerated(EnumType.STRING)
    @Column(name = "action")
    private ActionEnum action;

    @Column(name = "created_at", updatable = false)
    private LocalDateTime createdAt;

    // Getter and setter methods for all fields...

    public void setTimesheetId(Integer timesheetId) {
        this.timesheetId = timesheetId;
    }

    public void setEmployee(Integer employee) {
        this.userId = employee;
    }

    public void setProject(Integer project) {
        this.projectId = project;
    }

    public void setTodo(Integer todo) {
        this.projectId = todo;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public void setStartTime(LocalTime startTime) {
        this.startTime = startTime;
    }

    public void setEndTime(LocalTime endTime) {
        this.endTime = endTime;
    }

    public void setBillable(boolean billable) {
        this.billable = billable;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public void setDuration(LocalTime duration) {
        this.duration = duration;
    }

    public void setManual(boolean manual) {
        this.manual = manual;
    }

    public void setAction(ActionEnum action) {
        this.action = action;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public enum ActionEnum {
        Add, Edit, Delete, None
    }

}
