package com.reportsMicroservice.demo.model.reports;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class WorkSessionReport {
    @Id
    @GeneratedValue
    private UUID id;

    private String clientName;
    private String projectName;
    private String memberName;
    private String todoDescription;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private double duration;
    // private String activity;

}
