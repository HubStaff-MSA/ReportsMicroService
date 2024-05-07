package com.reportsMicroservice.demo.model;


import jakarta.persistence.*;
import lombok.Getter;

import java.util.Date;

@Getter
@Entity
@Table(name = "Shift")
public class Shift {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "shift_id")
    private int shiftId;

    @ManyToOne
    @JoinColumn(name = "employee_id", referencedColumnName = "id")  // Changed from member_id to employee_id for clarity
    private User employee;

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

    public void setShiftId(int shiftId) {
        this.shiftId = shiftId;
    }

    public void setEmployee(User employee) {
        this.employee = employee;
    }

    public void setStartDatetime(Date startDatetime) {
        this.startDatetime = startDatetime;
    }

    public void setEndDatetime(Date endDatetime) {
        this.endDatetime = endDatetime;
    }

    public void setTimeZone(String timeZone) {
        this.timeZone = timeZone;
    }

    public void setMinimumHours(double minimumHours) {
        this.minimumHours = minimumHours;
    }

    public void setRepeats(RepeatType repeats) {
        this.repeats = repeats;
    }

    public void setRepeatDayOfWeek(String repeatDayOfWeek) {
        this.repeatDayOfWeek = repeatDayOfWeek;
    }

    public void setRepeatUntilDate(Date repeatUntilDate) {
        this.repeatUntilDate = repeatUntilDate;
    }

    public void setIssueStatus(IssueStatus issueStatus) {
        this.issueStatus = issueStatus;
    }
}
