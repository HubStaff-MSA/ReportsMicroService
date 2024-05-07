package com.reportsMicroservice.demo.model;

import jakarta.persistence.*;
import lombok.Getter;

import java.util.Date;

@Getter
@Entity
@Table(name = "time_off")
public class Time_off {
    @Id
    @Column(name = "time_off_id")
    private int timeOffId;

    @ManyToOne
    @JoinColumn(name = "employee_id", referencedColumnName = "id")  // Changed from member_id to employee_id for clarity
    private User employee;  // Renamed field from member to employee

    @ManyToOne
    @JoinColumn(name = "approved_by", referencedColumnName = "id")
    private User approvedBy;

    @ManyToOne
    @JoinColumn(name = "changed_by", referencedColumnName = "id")
    private User changedBy;

    @Column(name = "policy")
    private String policy;

    @Column(name = "start_date")
    private Date startDate;

    @Column(name = "end_date")
    private Date endDate;

    @Column(name = "duration")
    private int duration;

    @Column(name = "type")
    private String type;

    @Column(name = "reason")
    private String reason;

    // Getters and setters (omitted for brevity)


    public void setTimeOffId(int timeOffId) {
        this.timeOffId = timeOffId;
    }

    public void setEmployee(User employee) {
        this.employee = employee;
    }

    public void setApprovedBy(User approvedBy) {
        this.approvedBy = approvedBy;
    }

    public void setChangedBy(User changedBy) {
        this.changedBy = changedBy;
    }

    public void setPolicy(String policy) {
        this.policy = policy;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }
}
