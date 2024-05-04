package com.reportsMicroservice.demo.model;


import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "Shift")
public class Shift {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "shift_id")
    private int shiftId;

    @ManyToOne
    @JoinColumn(name = "member_id")
    private Employee member;

    @Column(name = "start_datetime")
    private Date startDatetime;

    @Column(name = "end_datetime")
    private Date endDatetime;

    @Column(name = "time_zone")
    private String timeZone;

    @Column(name = "minimum_hours")
    private double minimumHours;

    @Column(name = "repeats")
    @Enumerated(EnumType.STRING)
    private RepeatType repeats;

    @Column(name = "repeat_day_of_week")
    private String repeatDayOfWeek;

    @Column(name = "repeat_until_date")
    private Date repeatUntilDate;

    @Column(name = "issue_status")
    @Enumerated(EnumType.STRING)
    private IssueStatus issueStatus;


    public enum RepeatType {
        NEVER, WEEKLY, BI_WEEKLY
    }

    public enum IssueStatus {
        NOT_STARTED, ON_TIME, LATE, ABANDONED, MISSED
    }
    // Getters and setters (omitted for brevity)

}
