package com.reportsMicroservice.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDate;

@AllArgsConstructor
@Setter
@Getter
public class UserDTO implements Serializable {

    private Integer id;
    private String fullName;
    private String workEmail;
    private String Department;
    private String Position;
    private String TimeZone;
    //---------------------------------------------Employee fields---------------------------------------------
    private LocalDate hireDate;
    private double hourlyRate;
    private double salary;
    private String taxInfo;
    private Integer usedTimeOff;
    private Integer pendingTimeOff;
    private Integer balanceTimeOff;
    private double totalHoursWorked;
    private double weeklyLimit;

    private LocalDate DateRemoved;
    private String PayType;
    private Integer PayRate;
    private Integer DailyLimit;
    private boolean TrackingEnabled;
    private boolean TimesheetsEnabled;
    private String Status;

}
