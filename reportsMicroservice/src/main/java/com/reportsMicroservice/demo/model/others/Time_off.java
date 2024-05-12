package com.reportsMicroservice.demo.model.others;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.cglib.core.Local;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
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
    private LocalDate startDate;
    private LocalDate endDate;
    private String type;
    private String reason;


    public double calculateDuration() {
        return ChronoUnit.HOURS.between(startDate.atStartOfDay(), endDate.atStartOfDay());
    }
}
