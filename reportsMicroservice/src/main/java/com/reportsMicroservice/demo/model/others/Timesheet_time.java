package com.reportsMicroservice.demo.model.others;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;

@Getter
@Setter
@AllArgsConstructor
public class Timesheet_time {

    private Integer timesheetId;
    private Integer organizationId;
    private Integer userId;
    private Integer projectId;
    private Integer todoId;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate day;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime startTime;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime endTime;

    private Long duration;
    private boolean manual;

}
