package com.reportsMicroservice.demo.model.others;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;

@Getter
@Setter
@AllArgsConstructor
public class Timesheet_time {

    private Integer timesheetId;
    private Integer userId;
    private Integer projectId;
    private Integer todoId;
    private LocalDate date;
    private LocalTime startTime;
    private LocalTime endTime;
    private boolean billable;
    private boolean manual;
    private ActionEnum action;

    public double calculateDurationInHours() {
        return ChronoUnit.MINUTES.between(startTime, endTime) / 60.0;
    }

    public enum ActionEnum {
        Add, Edit, Delete, None
    }

}
