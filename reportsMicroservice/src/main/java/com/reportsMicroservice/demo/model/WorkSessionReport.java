package com.reportsMicroservice.demo.model;

import jakarta.persistence.*;
import lombok.Getter;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Getter
//@Entity
//@Table(name = "WorkSessionReport")
public class WorkSessionReport {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name = "workSessionReportId")

    private String clientName;
    private String projectName;
    private String memberName;
    private String todoDescription;
    private boolean isManual;
    private LocalTime startTime;
    private LocalTime endTime;
    private LocalTime duration;
    private String activity;

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public void setMemberName(String memberName) {
        this.memberName = memberName;
    }

    public void setTodo(String todoDescription) {
        this.todoDescription = todoDescription;
    }

    public void setManual(boolean manual) {
        isManual = manual;
    }

    public void setStartTime(LocalTime startTime) {
        this.startTime = startTime;
    }

    public void setEndTime(LocalTime endTime) {
        this.endTime = endTime;
    }

    public void setDuration(LocalTime duration) {
        this.duration = duration;
    }

    public void setActivity(String activity) {
        this.activity = activity;
    }
}
