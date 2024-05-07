package com.reportsMicroservice.demo.model;

import jakarta.persistence.*;
import lombok.Getter;

import java.util.List;
import java.util.Set;

@Getter
@Entity
@Table(name = "Project")
public class Project {
    @Id
    @Column(name = "projectId")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long projectId;

    @Getter
    @Column(name = "projectName", nullable = false)
    private String projectName;

    @Getter
    @Column(name = "budget", nullable = false)
    private double budget;

    @Getter
    @Column(name = "is_billable", nullable = false)
    private boolean billable;

    @Column(name = "disable_activity", nullable = false)
    private boolean disableActivity;

    @Getter
    @Column(name = "disable_idle_time", nullable = false)
    private boolean disableIdleTime;

    @Getter
    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;

    @ManyToMany
    @JoinTable(
            name = "project_user",
            joinColumns = @JoinColumn(name = "project_id"),
            inverseJoinColumns = @JoinColumn(name = "id")
    )
    private Set<User> users;
    // Getters and setters (omitted for brevity)

    public void setProjectId(Long projectId) {
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
