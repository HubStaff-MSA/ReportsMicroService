package com.reportsMicroservice.demo.repository;

import com.reportsMicroservice.demo.model.Timesheet_time;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface Timesheet_timeRepository extends JpaRepository<Timesheet_time, Long> {
}
