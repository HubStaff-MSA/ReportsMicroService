package com.reportsMicroservice.demo.dto;

import com.reportsMicroservice.demo.model.others.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@AllArgsConstructor
@Setter
@Getter
public class UserDTO {

    private Integer id;
    private User.UserRole role;
    private String fullName;
    private String email;
    private String password;
    private LocalDate joinDate;
    private Integer organizationId;
    private Integer projectId;
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

}
