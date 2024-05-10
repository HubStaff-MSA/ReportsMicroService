package com.reportsMicroservice.demo.model.others;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
public class Time_off {

    private Integer timeOffId;
    private Integer employeeId;
    private Integer approvedByUserId;
    private Integer changedByUserId;
    private String policy;
    private Date startDate;
    private Date endDate;
    private String type;
    private String reason;

}
