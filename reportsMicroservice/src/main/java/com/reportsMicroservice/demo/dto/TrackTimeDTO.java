package com.reportsMicroservice.demo.dto;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class TrackTimeDTO implements Serializable {

    @Id
    private Integer id;

    private int organizationID;

    private Integer userId;

    private String userName;

    private String project;

    private String to_do;

    private LocalDateTime startTime;

    private LocalDateTime endTime;

    private LocalDate day; // Adding the new column for day

    private Long duration;

    private float manual;

    public void setId(Long id) {
        this.id = Math.toIntExact(id);
    }

    public Integer getId() {
        return id;
    }
}
