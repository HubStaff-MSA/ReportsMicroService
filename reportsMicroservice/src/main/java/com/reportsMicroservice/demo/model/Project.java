package com.reportsMicroservice.demo.model;

import jakarta.persistence.*;
import lombok.Getter;

@Getter
@Entity
@Table(name = "Project")
public class Project {
    @Id
    @Column(name = "projectId")
    private String projectId;

    @Column(name = "projectName", nullable = false)
    private String projectName;

    @Column(name = "budget", nullable = false)
    private double budget;

    @Column(name = "is_billable", nullable = false)
    private boolean billable;

    @Column(name = "disable_activity", nullable = false)
    private boolean disableActivity;

    @Column(name = "disable_idle_time", nullable = false)
    private boolean disableIdleTime;

    @ManyToOne
    @JoinColumn(name = "client_id", nullable = false)
    private Client client;

    // Getters and setters (omitted for brevity)

    public void setProjectId(String projectId) {
        this.projectId = projectId;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public void setBudget(double budget) {
        this.budget = budget;
    }

    public void setBillable(boolean billable) {
        this.billable = billable;
    }

    public void setDisableActivity(boolean disableActivity) {
        this.disableActivity = disableActivity;
    }

    public void setDisableIdleTime(boolean disableIdleTime) {
        this.disableIdleTime = disableIdleTime;
    }

    public void setClient(Client client) {
        this.client = client;
    }
}
