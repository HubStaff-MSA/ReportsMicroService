package com.reportsMicroservice.demo.model;

import jakarta.persistence.*;

import java.time.Duration;
import java.time.LocalDateTime;


public class WorkSessionReport {
    private String clientName;
    private String projectName;
    private String memberName;
    private String todoDescription;
    private boolean isManual;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private Duration duration;
    private String activity;
}
