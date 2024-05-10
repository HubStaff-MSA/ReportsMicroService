package com.reportsMicroservice.demo.model.others;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
public class Shift {

    private Integer shiftId;
    private Integer employeeId;
    private LocalDateTime startDatetime;
    private LocalDateTime endDatetime;
    private String timeZone;
    private double minimumHours;
    private RepeatType repeats;
    private String repeatDayOfWeek;
    private Date repeatUntilDate;
    private IssueStatus issueStatus;


    public Shift(Integer shiftId, Integer employeeId, LocalDateTime startDatetime, LocalDateTime endDatetime, double minimumHours, RepeatType repeats, Date repeatUntilDate, IssueStatus issueStatus) {
        this.shiftId = shiftId;
        this.employeeId = employeeId;
        this.startDatetime = startDatetime;
        this.endDatetime = endDatetime;
        this.minimumHours = minimumHours;
        this.repeats = repeats;
        this.repeatUntilDate = repeatUntilDate;
        this.issueStatus = issueStatus;
    }

    public enum RepeatType {
        NEVER, WEEKLY, BI_WEEKLY
    }

    public enum IssueStatus {
        NOT_STARTED, ON_TIME, LATE, ABANDONED, MISSED
    }
}
