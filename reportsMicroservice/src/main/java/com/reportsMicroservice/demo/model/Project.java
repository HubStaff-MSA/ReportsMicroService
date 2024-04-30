package com.reportsMicroservice.demo.model;

import jakarta.persistence.*;

@Entity
@Table(name = "Project")
public class Project {
    @Id
    @Column(name = "project_id")
    private String projectId;

    @Column(name = "project_name", nullable = false)
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

    public String getProjectId() {
        return projectId;
    }

    public void setProjectId(String projectId) {
        this.projectId = projectId;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public double getBudget() {
        return budget;
    }

    public void setBudget(double budget) {
        this.budget = budget;
    }

    public boolean isBillable() {
        return billable;
    }

    public void setBillable(boolean billable) {
        this.billable = billable;
    }

    public boolean isDisableActivity() {
        return disableActivity;
    }

    public void setDisableActivity(boolean disableActivity) {
        this.disableActivity = disableActivity;
    }

    public boolean isDisableIdleTime() {
        return disableIdleTime;
    }

    public void setDisableIdleTime(boolean disableIdleTime) {
        this.disableIdleTime = disableIdleTime;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }
}
