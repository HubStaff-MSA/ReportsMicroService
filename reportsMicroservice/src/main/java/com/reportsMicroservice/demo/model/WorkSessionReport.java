package com.reportsMicroservice.demo.model;

import jakarta.persistence.*;
import lombok.Getter;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.LocalTime;


public class WorkSessionReport {
    @Getter
    private String clientName;
    @Getter
    private String projectName;
    @Getter
    private String memberName;
    @Getter
    private String todoDescription;
    private boolean isManual;
    @Getter
    private LocalTime startTime;
    @Getter
    private LocalTime endTime;
    @Getter
    private LocalTime duration;
    @Getter
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

    public boolean isManual() {
        return isManual;
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
