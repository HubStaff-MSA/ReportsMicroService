package com.reportsMicroservice.demo.model;

import jakarta.persistence.*;
import jdk.jfr.DataAmount;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;


@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
@Table(name = "Employee")
public class Employee extends User {

    @Column(name = "address")
    private String address;

    @Column(name = "phoneNumber")
    private String phoneNumber;

    @Column(name = "hireDate")
    private LocalDate hireDate;

    @Column(name = "hourlyRate")
    private BigDecimal hourlyRate;

    @Column(name = "salary")
    private BigDecimal salary;

    @Column(name = "employmentStatus")
    private String employmentStatus;

    @Column(name = "taxInfo")
    private String taxInfo;

    @Column(name = "usedTimeOff")
    private Integer usedTimeOff;

    @Column(name = "pendingTimeOff")
    private Integer pendingTimeOff;

    @Column(name = "balanceTimeOff")
    private Integer balanceTimeOff;

    @Column(name = "totalHoursWorked")
    private BigDecimal totalHoursWorked;

    @Column(name = "weeklyLimit")
    private BigDecimal weeklyLimit;

    // Constructors, getters, and setters (omitted for brevity)

    public BigDecimal getHourlyRate() {
        return hourlyRate;
    }

    public void setHourlyRate(BigDecimal hourlyRate) {
        this.hourlyRate = hourlyRate;
    }

    public BigDecimal getSalary() {
        return salary;
    }

    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }

    public String getEmploymentStatus() {
        return employmentStatus;
    }

    public void setEmploymentStatus(String employmentStatus) {
        this.employmentStatus = employmentStatus;
    }

    public String getTaxInfo() {
        return taxInfo;
    }

    public void setTaxInfo(String taxInfo) {
        this.taxInfo = taxInfo;
    }

    public Integer getUsedTimeOff() {
        return usedTimeOff;
    }

    public void setUsedTimeOff(Integer usedTimeOff) {
        this.usedTimeOff = usedTimeOff;
    }

    public Integer getPendingTimeOff() {
        return pendingTimeOff;
    }

    public void setPendingTimeOff(Integer pendingTimeOff) {
        this.pendingTimeOff = pendingTimeOff;
    }

    public Integer getBalanceTimeOff() {
        return balanceTimeOff;
    }

    public void setBalanceTimeOff(Integer balanceTimeOff) {
        this.balanceTimeOff = balanceTimeOff;
    }

    public BigDecimal getTotalHoursWorked() {
        return totalHoursWorked;
    }

    public void setTotalHoursWorked(BigDecimal totalHoursWorked) {
        this.totalHoursWorked = totalHoursWorked;
    }

    public BigDecimal getWeeklyLimit() {
        return weeklyLimit;
    }

    public void setWeeklyLimit(BigDecimal weeklyLimit) {
        this.weeklyLimit = weeklyLimit;
    }
}