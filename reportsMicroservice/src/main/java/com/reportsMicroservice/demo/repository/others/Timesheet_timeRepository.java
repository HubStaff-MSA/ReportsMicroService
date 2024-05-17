package com.reportsMicroservice.demo.repository.others;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.reportsMicroservice.demo.model.others.Timesheet_time;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Repository

public class Timesheet_timeRepository {
    List<Timesheet_time> timesheettimes = new ArrayList<>();

    public Timesheet_timeRepository() {
        timesheettimes.add(new Timesheet_time(1, 1, 1, 1,1, LocalDate.of(2021, 01, 01), LocalDateTime.of(2021, 1, 1, 15, 0), LocalDateTime.of(2021, 5, 15, 15, 0), 5L, false));
        timesheettimes.add(new Timesheet_time(2, 2, 2, 2,2, LocalDate.of(2021, 01, 01), LocalDateTime.of(2021, 1, 1, 15, 0), LocalDateTime.of(2021, 5, 15, 15, 0), 5L, false));
        timesheettimes.add(new Timesheet_time(3, 3, 3, 3,3, LocalDate.of(2021, 01, 01), LocalDateTime.of(2021, 1, 1, 15, 0), LocalDateTime.of(2021, 5, 15, 15, 0), 5L, false));
    }

    //find timesheet by user id (not a list)
    public Timesheet_time findByUserId(Integer userId) {
        return timesheettimes.stream()
                .filter(timesheet_time -> timesheet_time.getUserId().equals(userId))
                .findFirst()
                .orElse(null);
    }

    public Timesheet_time findById(Integer id) {
        return timesheettimes.stream()
                .filter(timesheet_time -> timesheet_time.getTimesheetId().equals(id))
                .findFirst()
                .orElse(null);
    }

    //findBy project id
    public List<Timesheet_time> findByProjectId(Integer projectId) {
        return timesheettimes.stream()
                .filter(timesheet_time -> timesheet_time.getProjectId().equals(projectId))
                .collect(java.util.stream.Collectors.toList());
    }

    public List<Timesheet_time> findByTodoId(Integer todoId) {
        return timesheettimes.stream()
                .filter(timesheet_time -> timesheet_time.getTodoId().equals(todoId))
                .collect(java.util.stream.Collectors.toList());
    }


    public List<Timesheet_time> findByDateRange(LocalDate from, LocalDate to) {
        return timesheettimes.stream()
                .filter(timesheet_time -> timesheet_time.getDay().isAfter(from) && timesheet_time.getDay().isBefore(to))
                .collect(java.util.stream.Collectors.toList());
    }

    public List<Timesheet_time> findAll() {
        return timesheettimes;
    }
}
