package com.reportsMicroservice.demo.model.reports;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
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
