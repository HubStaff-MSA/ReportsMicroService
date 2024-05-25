package com.reportsMicroservice.demo.dto;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;


@Data
@Builder
public class TT_dto {

//    private Map<Integer,Float> mapOfUserIDDuration;

//    private Map<String,Map<Integer,Float>> mapOfUserIDProjectNameDuration;

    private int organizationID;

    private Integer userId;

    private String project;

    private String to_do;

    private String userName;

    private LocalDateTime startTime;

    private LocalDateTime endTime;

    private LocalDate day; // Adding the new column for day

    private Long duration;

}
