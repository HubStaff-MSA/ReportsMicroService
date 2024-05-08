package com.reportsMicroservice.demo.model;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Entity
@Table(name = "'User'")
@DiscriminatorColumn(name = "type")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Getter
    @Enumerated(EnumType.STRING)
    @Column(name = "role", nullable = false)
    private UserRole role;

    @Getter
    @Column(name = "fullName", nullable = false)
    private String fullName;

    @Getter
    @Column(name = "email", unique = true, nullable = false)
    private String email;

    @Getter
    @Column(name = "password", nullable = false)
    private String password;

    public enum UserRole {
        USER, OWNER, ORGANIZATION_MANAGER, PROJECT_MANAGER
    }

    @Column(name = "joinDate")
    private LocalDate joinDate;

    @Column(name = "organizationId")
    private Integer organizationId;

    //---------------------------------------------Employee fields---------------------------------------------

    @Getter
    @Column(name = "hireDate")
    private LocalDate hireDate;

    @Getter
    @Column(name = "hourlyRate")
    private BigDecimal hourlyRate;

    @Getter
    @Column(name = "salary")
    private BigDecimal salary;

    @Getter
    @Column(name = "employmentStatus")
    private String employmentStatus;

    @Getter
    @Column(name = "taxInfo")
    private String taxInfo;

    @Getter
    @Column(name = "usedTimeOff")
    private Integer usedTimeOff;

    @Getter
    @Column(name = "pendingTimeOff")
    private Integer pendingTimeOff;

    @Getter
    @Column(name = "balanceTimeOff")
    private Integer balanceTimeOff;

    @Getter
    @Column(name = "totalHoursWorked")
    private BigDecimal totalHoursWorked;

    @Getter
    @Column(name = "weeklyLimit")
    private BigDecimal weeklyLimit;

    public void setRole(UserRole role) {
        this.role = role;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setHireDate(LocalDate hireDate) {
        this.hireDate = hireDate;
    }

    public void setHourlyRate(BigDecimal hourlyRate) {
        this.hourlyRate = hourlyRate;
    }

    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }

    public void setEmploymentStatus(String employmentStatus) {
        this.employmentStatus = employmentStatus;
    }

    public void setTaxInfo(String taxInfo) {
        this.taxInfo = taxInfo;
    }

    public void setUsedTimeOff(Integer usedTimeOff) {
        this.usedTimeOff = usedTimeOff;
    }

    public void setPendingTimeOff(Integer pendingTimeOff) {
        this.pendingTimeOff = pendingTimeOff;
    }

    public void setBalanceTimeOff(Integer balanceTimeOff) {
        this.balanceTimeOff = balanceTimeOff;
    }

    public void setTotalHoursWorked(BigDecimal totalHoursWorked) {
        this.totalHoursWorked = totalHoursWorked;
    }

    public void setWeeklyLimit(BigDecimal weeklyLimit) {
        this.weeklyLimit = weeklyLimit;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setJoinDate(LocalDate joinDate) {
        this.joinDate = joinDate;
    }

    public void setOrganizationId(Integer organizationId) {
        this.organizationId = organizationId;
    }
}
