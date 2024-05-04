package com.reportsMicroservice.demo.model;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "time_off")
public class Time_off {
    @Id
    @Column(name = "time_off_id")
    private int timeOffId;

    @ManyToOne
    @JoinColumn(name = "employee_id")
    private Employee employee;

    @ManyToOne
    @JoinColumn(name = "approved_by")
    private Employee approvedBy;

    @ManyToOne
    @JoinColumn(name = "changed_by")
    private Employee changedBy;

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

}
