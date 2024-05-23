package com.reportsMicroservice.demo.model.reports;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.time.LocalTime;

@Getter
@Setter
@AllArgsConstructor
public class WorkSessionReport {

    private String clientName;
    private String projectName;
    private String memberName;
    private String todoDescription;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private double duration;
    // private String activity;

}
