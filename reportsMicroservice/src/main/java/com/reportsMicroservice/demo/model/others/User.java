package com.reportsMicroservice.demo.model.others;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class User {

    private Integer id;
    private UserRole role;
    private String fullName;
    private String email;
    private String password;

    public enum UserRole {
        USER, OWNER, ORGANIZATION_MANAGER, PROJECT_MANAGER
    }


    private LocalDate joinDate;
    private Integer organizationId;
    private Integer projectId;

    //---------------------------------------------Employee fields---------------------------------------------
    private LocalDate hireDate;
    private BigDecimal hourlyRate;
    private BigDecimal salary;
    private String employmentStatus;
    private String taxInfo;
    private Integer usedTimeOff;
    private Integer pendingTimeOff;
    private Integer balanceTimeOff;
    private BigDecimal totalHoursWorked;
    private BigDecimal weeklyLimit;

    public User(Integer id, UserRole role, String fullName, String email, String password, LocalDate joinDate, Integer organizationId, Integer projectId) {
        this.id = id;
        this.role = role;
        this.fullName = fullName;
        this.email = email;
        this.password = password;
        this.joinDate = joinDate;
        this.organizationId = organizationId;
        this.projectId = projectId;
    }


}
